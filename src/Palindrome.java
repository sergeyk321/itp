public class Palindrome {
    public static void main(String[] args) {

        for(int i = 0; i < args.length; i++) {

            String s = args[i]; // значения вписываем в конце команды
            //boolean isPalindrome = s.equals(reverseString(s));
            System.out.println(s + " " + is(s));
        }
    }
    public static String reverseString(String s) {
        String rev = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev; // цикл закончен, возвращаем результат в reverseString
    }
    public static boolean is(String s) {
        return(reverseString(s).equals(s));
    }
}