package lab4;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;

public class FractalExplorer {
    private int displaySize;

    private static final String TITLE = "Fractal Explorer";
    private static final String RESET = "Reset Display";
    private JImageDisplay display; //объекты. для обновления отображения 
    private FractalGenerator fractal; //для отображения других фрактолов
    private Rectangle2D.Double range; //указывает диапозон комплексной плоскости

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
        JButton resetButton = new JButton(RESET); // кнопка сброса
        ResetButtonHandler resetButtonHandler = new ResetButtonHandler();
        resetButton.addActionListener(resetButtonHandler);
        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);
        frame.add(resetButton, BorderLayout.SOUTH); //кнопка в позиции
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
