public class capSpace { //ПРОБЕЛ ПЕРЕД КАЖДОЙ ЗАГЛАВНОЙ БУКВОЙ В СЛОВЕ
    public static void main(String[] args) {
        System.out.println(proga("iLoveTea"));
    }
    public static String proga(String s) {
        String ans = "";
        for(int i = 0; i<s.length(); i++) {
            char b = s.charAt(i);
            if(b == Character.toLowerCase(b))
                ans += b;
            else
                ans += " " + Character.toLowerCase(b);
        }
        return ans;
    }
}