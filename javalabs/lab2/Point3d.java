package lab2;

public class Point3d extends Point2d {
    // Поля координат
    private double zCoord;
    // Конструктор инициализации
    public Point3d(double x, double y, double z) {
        super(x, y);
        zCoord = z;
    }
    // Конструктор по умолчанию
    public Point3d() {
        super(0,0);
        zCoord = 0;
    }
    public static boolean equals(Point3d obj1, Point3d obj2) {
        if ((obj1.getX() == obj2.getX()) && (obj1.getY() == obj2.getY()) && (obj1.getZ() == obj2.getZ()))
            return true;
        else
            return false;
    }
    // Возвращение координат
    public static double distanceTo(Point3d obj1, Point3d obj2) {
        double r = (Math.sqrt(
            Math.pow(obj2.getX() - obj1.getX(), 2) +
            Math.pow(obj2.getY() - obj1.getY(), 2) +
            Math.pow(obj2.getZ() - obj1.getZ(), 2)));
        return r;
    }
    public double getZ () {
        return zCoord;
    }
    // Установка значений
    public void setZ (double val) {
        zCoord = val;
    }
}