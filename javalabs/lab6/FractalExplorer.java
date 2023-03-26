package lab6;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import java.io.*;

//Класс для отображения фрактала
public class FractalExplorer {
    private int displaySize;
    private int rowsRemaining;
    //Константы, хардкоженные строки
    private static final String TITLE = "Fractal Explorer";
    private static final String RESET = "Reset Display";
    private static final String SAVE = "Save Image"; // добавили кнопку сейв
    private static final String CHOOSE = "Fractal:";
    private static final String COMBOBOX_CHANGE = "comboBoxChanged";
    private static final String SAVE_ERROR = "Ошибка при сохранении изображения";
    private JImageDisplay display; //объекты. для обновления отображения 
    private FractalGenerator fractal; //для отображения других фрактолов
    private Rectangle2D.Double range; //указывает диапозон комплексной плоскости
    private JComboBox<FractalGenerator> comboBox;
    private JButton resetButton;
    private JButton saveButton;

    //Имплементируем интерфейс ActionListener для обработки событий
    class ActionsHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals(RESET)){
                fractal.getInitialRange(range);
                drawFractal();
            } else if (command.equals(COMBOBOX_CHANGE)) {
                //JComboBox source = (JComboBox) e.getSource();;
                //fractal = (FractalGenerator) source.getSelectedItem();
                fractal.getInitialRange(range);
                display.clearImage();
                drawFractal();
            } else if (command.equals(SAVE)) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                fileChooser.setFileFilter(filter);
                fileChooser.setAcceptAllFileFilterUsed(false);
                if(fileChooser.showSaveDialog(display) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    String path = file.toString();
                    if(path.length() == 0) return;
                    if(!path.contains(".png")){
                        file = new File(path + ".png");
                    }
                    try {
                        javax.imageio.ImageIO.write(display.getImage(), "png", file);
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(display, exception.getMessage(), SAVE_ERROR, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    //Наследуем MouseAdapter для обработки событий мыши
    class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(rowsRemaining != 0) return;
            display.clearImage();
            int x = e.getX();
            //по координате дисплея получаем координату фрактала
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
            int y = e.getY();
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    // 6 лаб
    class FractalWorker extends javax.swing.SwingWorker<Object, Object> { 
        private int y;//вычисляемая строка
        private int [] rgb; //хранение вычисленных значений RGB
        public FractalWorker(int y) {
            this.y = y;
        }
        
        /*Вызывается в фоновом потоке и отвечает за выполнение длительной задачи. 
        Вместо того, чтобы рисовать изображение в окне, цикл должен будет сохранить каждое значение 
        RGB в соответствующем элементе целочисленного массива. */
        @Override
        protected Object doInBackground(){ // добавляем пиксели в массив и сохраняем их, метод в фоновом потоке
            rgb = new int[displaySize];
            int color;
            for(int x = 0; x < displaySize; x++){
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
                int iteration = fractal.numIterations(xCoord, yCoord);
                color = 0;
                if(iteration > 0){
                    float hue = 0.7f + (float) iteration / 200f;
                    color = Color.HSBtoRGB(hue, 1f, 1f);
                }
                rgb[x] = color;
            }
            return null;
        }

        // фоновая задача завершена
        @Override
        protected void done() { //отрисовывает фрактал
            for(int x = 0; x < displaySize; x++) //перебираем массив строк данных, которые вычислены в doInBackground()
                display.drawPixel(x, y, rgb[x]);
            display.repaint(0, 0, y, displaySize, 1); // область для перерисовки
            rowsRemaining--;
            if (rowsRemaining == 0) // отслеживаем количество оставшихся строк
                enableUI(true);
        }
    }

    public static void main(String[] args){
        FractalExplorer fractalExplorer = new FractalExplorer(600);
        fractalExplorer.createAndShowGUI();
    }

    //Конструктор класса
    public FractalExplorer(int displaySize){
        this.displaySize = displaySize;
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double(); //хранение координат фрактала
        fractal.getInitialRange(range); //вызов метода для фрактала
    }

    //Метод для инициализации графического интерфейса Swing
    public void createAndShowGUI(){
        ActionsHandler actionsHandler = new ActionsHandler();
        //рамка с названием
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JImageDisplay(displaySize, displaySize);
        frame.add(display, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        JLabel label = new JLabel(CHOOSE);
        topPanel.add(label);

        //ComboBox - выбор фрактала
        comboBox = new JComboBox<>(); //селектор
        comboBox.addItem(new Mandelbrot());
        comboBox.addItem(new Tricorn());
        comboBox.addItem(new BurningShip());
        comboBox.addActionListener(actionsHandler);
        topPanel.add(comboBox, BorderLayout.NORTH);

        saveButton = new JButton(SAVE);
        saveButton.addActionListener(actionsHandler); //обработчик сохранения
        bottomPanel.add(saveButton, BorderLayout.WEST);

        resetButton = new JButton(RESET); //кнопка сброса
        resetButton.addActionListener(actionsHandler);
        bottomPanel.add(resetButton, BorderLayout.EAST);

        frame.add(bottomPanel, BorderLayout.SOUTH); //рамка
        frame.add(topPanel, BorderLayout.NORTH);

        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);

        frame.pack();
        frame.setVisible(true); //отрисовка элементов
        frame.setResizable(false); //запрет на изменение размера экрана
        drawFractal();
    }

    private void enableUI(boolean val){ 
        //включает и отключает кнопки
        comboBox.setEnabled(val);
        resetButton.setEnabled(val);
        saveButton.setEnabled(val);
    }

    private void drawFractal(){
        enableUI(false); //отключить все элементы во время перерисовки
        rowsRemaining = displaySize; //колво строк = размер дисплея
        for(int y = 0; y < displaySize; y++){
            FractalWorker worker = new FractalWorker(y);
            worker.execute(); // многопоточность
        }
    }
}