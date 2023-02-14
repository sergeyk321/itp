import java.util.Arrays; //ПОВТОРЯЮЩИЕСЯ СИМВОЛЫ КОЛВО

public class duplicates {
    public static void main(String[] args) {
        System.out.println(exam("hello world"));
    }
    public static int exam(String k) {
        int n = 0;
        char [] s = k.toCharArray();
        Arrays.sort(s);
        for (int i = 1; i < s.length; i++) {
            if (s[i] == s[i-1])
                n++;
        }
        return n;
    }
}