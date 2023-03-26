import java.util.Scanner;

class MyProgram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double a = s.nextDouble();
        double b = s.nextDouble();
        double c = s.nextDouble();
        s.close();
        double su = b * (-1) / a;
        double pr = c / a;
        System.out.println(su + " " + pr);

    }
}