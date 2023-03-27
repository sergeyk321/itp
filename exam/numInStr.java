import java.util.ArrayList; //СТРОКА С ЧИСЛАМИ

public class numInStr {
    public static void main(String[] args) {
        System.out.println(exam(new String [] {""}));
    }
    public static ArrayList<String> exam(String [] s) {
        String numbers = "0123456789";
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            String k = s[i];
            for (int j = 0; j < k.length(); j++) {
                char t = k.charAt(j);
                for (int l = 0; l <= 9; l++) {
                    if (t == numbers.charAt(l)) 
                        ans.add(k);
                }
                for (int r = 1; r < ans.size(); r++) {
                    if (ans.get(r).equals(ans.get(r-1)))
                        ans.remove(r-1);
                }
            }
        }
        return ans;
    }
}