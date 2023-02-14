public class isTriplet { //ПИФАГОРОВА ТРОЙКА
    public static void main(String[] args) {
        System.out.println(exam(4, 5, 3));
    }
    public static boolean exam(int a, int b, int c) {
        return a*a == b*b + c*c || b*b == a*a + c*c || c*c == a*a + b*b;
    }
}