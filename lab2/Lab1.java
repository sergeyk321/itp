package lab2;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        System.out.println("Введите координаты первой точки через пробел");
        Scanner inp1 = new Scanner(System.in);
        int x1 = inp1.nextInt();
        int y1 = inp1.nextInt();
        int z1 = inp1.nextInt();
        System.out.println("Введите координаты второй точки через пробел");
        Scanner inp2 = new Scanner(System.in);
        int x2 = inp2.nextInt();
        int y2 = inp2.nextInt();
        int z2 = inp2.nextInt();
        System.out.println("Введите координаты третьей точки через пробел");
        Scanner inp3 = new Scanner(System.in);
        int x3 = inp3.nextInt();
        int y3 = inp3.nextInt();
        int z3 = inp3.nextInt();
        Point3d Point1 = new Point3d(x1, y1, z1);
        Point3d Point2 = new Point3d(x2, y2, z2);
        Point3d Point3 = new Point3d(x3, y3, z3);
        inp1.close();
        inp2.close();
        inp3.close();
        if(Point3d.equals(Point1, Point2) || Point3d.equals(Point1, Point3) || Point3d.equals(Point2, Point3))
            System.out.println("Две точки равны");
        else {
            System.out.println(computeArea(Point1, Point2, Point3));
            }
        }
    public static String computeArea(Point3d Point1, Point3d Point2, Point3d Point3) {
        double side12 = Point3d.distanceTo(Point1, Point2);
        double side13 = Point3d.distanceTo(Point1, Point3);
        double side23 = Point3d.distanceTo(Point2, Point3);
        double p = 0.5 * (side12 + side13 + side23);
        double s = Math.sqrt(p * (p - side12) * (p - side13) * (p - side23));
        String result = String.format("%.2f", s);
        return result;
    }
}
