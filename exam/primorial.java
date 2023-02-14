public class primorial { //ПРИМОРИАЛ
    public static void main(String[] args) {
        System.out.println(exam(8));
    }
    public static int exam(int s) {
        int ans = 1;
        int i = 0;
        int sc = 1;
        while (i <= s) {
            if (isPrime(sc)) {
                ans *= sc;
                i++;
            }
            sc++;
        }
        return ans;
    }
    public static boolean isPrime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}