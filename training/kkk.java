import java.util.Scanner;
//import java.util.Arrays;

class Example {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int[] v = new int[k];
        System.out.println(k);
        for (int i = 0; i < k; i++) 
            v[i] = s.nextInt();
        s.close();
        System.out.println(Con1(k, v));
        }
    public static int Con1(int k, int[] v) {
        for (int j = 1; j < k; j++) {
            if (v[j] < v[j - 1]) 
                return -1;
        }
        return v[v.length - 1] - v[0];
    }
}