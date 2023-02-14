public class combinations { //КОМБИНАЦИИ
    public static void main(String[] args) {
        System.out.println(exam(2, 4, 5, 0, 8));
    }
    public static int exam(int ...n) {
        int ans = 1;
        for (int i = 0; i < n.length; i++) {
            if (n[i] != 0)
                ans *= n[i];
        }
        return ans;
    }
}