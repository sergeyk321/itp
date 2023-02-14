package lab5;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.awt.event.*;

public class FractalExplorer {
    private int displaySize;

    private static final String TITLE = "Fractal Explorer";
    private static final String RESET = "Reset Display";
    private static final String SAVE = "Save Display"; // добавили кнопку сейв
    private JImageDisplay display; //объекты. для обновления отображения 
    private FractalGenerator fractal; //для отображения других фрактолов
    private Rectangle2D.Double range; //указывает диапозон комплексной плоскости
    private JComboBox<FractalGenerator> comboBox;

    //ActionListener - для кнопки сброса
    /** используется нереализованный метод (класс интерфейс), который реализуется
     *  implements означает, что используются элементы интерфейса в классе
     **/
    class ResetButtonHandler implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    //Имплемент интерфейса ActionListener для кнопки сброса (a.l. - нереализованный метод, который реализуется)
    class Handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (RESET.equals(command)){
                fractal.getInitialRange(range);
                drawFractal();
            }
            else if ("comboBoxChanged".equals(command)){
                fractal = (FractalGenerator) comboBox.getSelectedItem(); //поддержка нескольких фракталов
                fractal.getInitialRange(range);
                drawFractal();
            }
            else if (SAVE.equals(command)){ //обработка сейв
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png"); //сохранение только в пнг
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false); 
                if (chooser.showSaveDialog(display)==JFileChooser.APPROVE_OPTION) { //открытие диалогового окна
                    File file = chooser.getSelectedFile(); //настройки для файла
                    String path = file.toString(); //путь
                    if (path.length() == 0)
                        return;
                    if (!path.contains(".png"))
                        file = new File(path+".png");
                    try {
                        javax.imageio.ImageIO.write(display.getImage(), "png", file); //записал изображение в файл
                    }
                    //обработка ошибок
                    catch (Exception exception) {
                        JOptionPane.showMessageDialog(display, exception.getMessage(), "Cannot save file", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        }
    }
    
    class MouseHandler extends MouseAdapter { //создается подкласс от класса, который расширяется
        @Override
        public void mouseClicked(MouseEvent e) { // считывание координат мышки
            display.clearImage();
            // по координате дисплея получаем координату фрактала
            int x = e.getX();
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
            int y = e.getY();
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    public static void main(String[] args){
        FractalExplorer fractalExplorer = new FractalExplorer(800);
        fractalExplorer.createAndShowGUI();
    }

    //Конструктор класса
    public FractalExplorer(int displaySize){
        this.displaySize = displaySize;
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double(); //создаётся класс для хранения координат фрактала
        fractal.getInitialRange(range); //вызывается метод для определённого фрактала и в объект помещаются определённые координаты
    }

    public void createAndShowGUI(){
        JFrame frame = new JFrame(TITLE); // устанавливается рамка с названием
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new JImageDisplay(displaySize, displaySize);
        frame.add(display, BorderLayout.CENTER); //добавляем объект отображения

        Handler handler = new Handler();

        //объявление панелей
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();

        JLabel label = new JLabel("Fractal: ");
        top.add(label,BorderLayout.NORTH);

        comboBox = new JComboBox<FractalGenerator>(); //окно сверху
        comboBox.addItem(new Mandelbrot());
        comboBox.addItem(new Tricorn());
        comboBox.addItem(new BurningShip());
        comboBox.addActionListener(handler); //добавили поддержку выпадающего списка
        top.add(comboBox,BorderLayout.EAST);
        
        JButton saveButton = new JButton(SAVE); //кнопка сейв
        saveButton.addActionListener(handler); 
        bottom.add(saveButton,BorderLayout.WEST);

        JButton resetButton = new JButton(RESET); //кнопка ресет
        resetButton.addActionListener(handler);
        bottom.add(resetButton, BorderLayout.EAST);

        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);

        frame.add(bottom,BorderLayout.SOUTH);//рамка
        frame.add(top,BorderLayout.NORTH);
        
        frame.pack();
        frame.setVisible(true); //отрисовка элементов интерфейса
        frame.setResizable(false); //запрет на изменение размера экрана
        drawFractal();
    }

    //Метод для отрисовки фрактала
    private void drawFractal(){
        for(int i = 0; i < displaySize; i++){
            for(int j = 0; j < displaySize; j++){
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, i); //координаты в пространстве фрактала
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, j);
                int iteration = fractal.numIterations(xCoord, yCoord);
                if (iteration == -1) { //точка не выходит за границы
                    display.drawPixel(i, j, 0);
                }
                else { //выбираем цвет на основе кол-ва итераций
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    display.drawPixel(i, j, rgbColor);
                }
            }
            display.repaint(); // обновление изображения на экране
        }
    }
}