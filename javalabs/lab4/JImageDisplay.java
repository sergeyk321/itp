package lab4;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;
public class JImageDisplay extends javax.swing.JComponent{
    //приватное поле для управления изображением
    private BufferedImage img; 
    
    public JImageDisplay(int width, int height) {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); //инициализация объекта с типом изображения t.i.r.
        Dimension dim = new Dimension(width, height); 
        super.setPreferredSize(dim); //метод родительского класса, вызов метода, который отобразит изображение
    }
    
    @Override //собственный код для отрисовки  
    public void paintComponent(Graphics g) { 
        super.paintComponent(g); //вызов метода суперкласса
        g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
    }

    public void clearImage() {
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                img.setRGB(i, j, 0); //0 - пиксель черный
            }
        }
    }
    public void drawPixel(int x, int y, int rgbColor) {
        img.setRGB(x, y, rgbColor); //пиксель в определённый цвет
    }
}
