public class task {
    public static void main(String[] args) {
        System.out.println(longestZero("59001"));
    }
    public static String longestZero(String s) {
        if (s.length() == 0) 
            return "";
        if (s.length() == 1 && s.charAt(0)== 0) 
            return "0";
        int max = 0;
        int l = 1;
        String k = "0";
        String z = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == 0 && s.charAt(i) == 0) {
                l++;
                k += s.charAt(i); 
            }
            else {
                max = Math.max(max, l);
                l = 1;
            }
        }
        for (int y = 1; y < max; y++){ 
            z += "0";
        }
        return z;
    }
}
