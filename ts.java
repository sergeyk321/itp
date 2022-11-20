public class ts {
    public static void main(String[] args) {
        System.out.println(longestZero("01000"));
    }
    // 8/10
    public static String longestZero(String s) {
        int maxL = 0;
        String zero;
        String maxZ = "";
        String [] zeros = s.split("1");             
        //for (String zero : zeros) {
        for (int i = 0; i < zeros.length; i++) {
            zero = zeros[i];
            System.out.println(zero);
            if (zero.length() > maxL) {
                maxL = zero.length();
                maxZ = zero;
            }
        }
        return maxZ;
    }
}