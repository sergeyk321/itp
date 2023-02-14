public class histogram { //ГИСТОГРАММА
    public static void main(String[] args) {
        System.out.println(exam(new int [] {5, 3, 2}, "-"));
    }
    public static String exam(int [] array, String s) {
        String ans = "";
        for (int i = 0; i < array.length; i++) {
            int n = array[i];
            for (int j = 0; j < n; j++) 
                ans += s;
            ans += "\n";
        }
        ans = ans.substring(0, ans.length()-1);
        return ans;
    }
}