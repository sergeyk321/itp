public class test {
    public static void main(String[] args) {
        System.out.println(longestZero("010010001"));
    }
    // 8/10
    public static int longestZero(String s) {
        int k = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                k += 1;
            else if (k != '0') {
                if (k > max) {
                    max = k;
                    k = 0;    
                }
            }
        }     
        return max;
    }
}
