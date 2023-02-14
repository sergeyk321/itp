public class littleBig { //ПОСЛЕДОВАТЕЛЬНОСТЬ
    public static void main(String[] args) {
        System.out.println(lil(4));
    }
    public static int lil(int n) {
        if (n == 1) 
            return 5;
        if (n == 2) 
            return 100;
        else {
            int ans = 0;
            int [] k = new int[n];
            k[0] = 5;
            k[1] = 100;
            if (n % 2 == 0) {
                for (int i = 3; i <= n; i += 2)
                    k[i] = k[i-2] * 2;
            }
            else {
                for (int i = 2; i <= n; i += 2)
                    k[i] = k[i-2] + 1;
            }
            ans = k[n-1];
            return ans;
        }
    }
}