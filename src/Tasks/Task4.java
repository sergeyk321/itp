package Tasks;

import java.util.ArrayList;
import java.util.Collections;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Task 1/10");
        System.out.println(Bessie(10, 7, "Hello my name is Bessie and this is my essay"));
        System.out.println("Task 2/10");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((())(()))(()())"));
        System.out.println("Task 3/10");
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println("Task 4/10");
        System.out.println(overtime(new double [] {9, 17, 30, 1.5}));
        System.out.println(overtime(new double [] {16, 18, 30, 1.8}));
        System.out.println(overtime(new double [] {13.25, 15, 30, 1.5}));
        System.out.println("Task 5/10");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println("Task 6/10");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println("Task 7/10");
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));   
        System.out.println(toStarShorthand("abc"));
        System.out.println("Task 8/10");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));
        System.out.println("Task 9/10");
        System.out.println(trouble(451999277, 41177722899L));
        System.out.println(trouble(1222345, 12345));
        System.out.println(trouble(666789, 12345667));
        System.out.println(trouble(33789, 12345337));
        System.out.println("Task 10/10");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
    }
    // 1/10
    public static String Bessie(int n, int k, String l) {
        String [] words = l.split(" ");
        String answer = "";
        int sl = 0;
        for (int i = 0; i < words.length; i++) {
            if (sl + words[i].length() <= k) {
                answer += words[i] + " ";
                sl += words[i].length();
            } else {
                answer += "\n" + words[i] + " ";
                sl = words[i].length();
            }
        }
        return answer;
    }
    // 2/10
    public static ArrayList<String> split(String l) {
        int left = 0;
        int right = 0;
        String p = "";
        ArrayList<String> pairs = new ArrayList<>();
        for (int i = 0; i < l.length(); i++) {
            if (l.charAt(i) == '(') {
                p += "(";
                left++;
            } else {
                p += ")";
                right++;
                if (left == right) {
                    pairs.add(p);
                    p = "";
                    left = right = 0;
                }
            }
            }
        return pairs;
    }
    // 3/10 
    public static String toCamelCase(String s){
        String k = "";
        boolean f = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '_')
                f = true;
            else if (f == true) {
                k += Character.toUpperCase(s.charAt(i));
                f = false;    
            } else 
                k += s.charAt(i);
            }
        return k;
        }
    // 3/10
    public static String toSnakeCase(String s) {
        String k = "";
        char b;
        for (int i = 0; i< s.length(); i++) {
            b = s.charAt(i);
            if (b <= 'Z' && b >= 'A') {
                k += "_" + Character.toLowerCase(b);
            } else
                k += b;
            }
            return k;
    }
    // 4/10
    public static String overtime(double [] s) {
        double start = s[0];
        double end = s[1];
        double st = s[2];
        double x = s[3];
        if (end <= 17)
            return "$" + Double.toString((Math.ceil((end - start) * st * 100) / 100));
        else 
            return "$" + Double.toString((Math.ceil(((17 - start) * st + (end - 17) * st * x) * 100) / 100));
    }
    // 5/10
    public static String BMI(String weight, String height) {
        double w, h;
        if (weight.contains("pounds")) 
            w = Double.parseDouble(weight.substring(0, weight.indexOf(" "))) / 2.204;
        else 
            w = Double.parseDouble(weight.substring(0, weight.indexOf(" ")));
        if (height.contains("inches")) 
            h = Double.parseDouble(height.substring(0, height.indexOf(" "))) *0.0254;
        else 
            h = Double.parseDouble(height.substring(0, height.indexOf(" ")));
            System.out.println(h);
        double imt = Math.ceil(w/(h*h) * 10) / 10;
        if (imt >= 25)
            return Double.toString(imt) + " Overweight";
        if (imt < 18.5) 
            return Double.toString(imt) + " Underweight";
        else
            return Double.toString(imt) + " Normal weight";
    }
    // 6/10
    public static int bugger(int n) {
        int x = n;
        int k = 0;
        while (x > 9) {
            x = 1;
            while (n > 0) {
                x *= n % 10;
                n /= 10;
            }
        k += 1;
        n = x;
        }
        return k;
    }
    // 7/10
    public static String toStarShorthand(String s){
        if (s.isEmpty())
            return "";
        String str = new String();
        char x = s.charAt(0);
        int k = 1;
        for (int i = 1; i < s.length(); i++) {
            if (x != s.charAt(i)) {
                if (k == 1)
                    str += x;
                else
                    str += x + "*" + k;
                k = 1;
                x = s.charAt(i);
            }
            else
                k++;
        }
        if (k == 1)
            str += x;
        else 
            str += x + "*" + k;
        return str;
    }
    // 8/10
    public static boolean doesRhyme(String str1, String str2) {
        String lets = "aeiouyAEIOUY";
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        String [] arr1 = (str1.substring(0, str1.length()-1)).split(" ");
        String [] arr2 = (str2.substring(0, str2.length()-1)).split(" ");
        String word1 = (arr1[arr1.length-1]).toLowerCase();
        String word2 = (arr2[arr2.length-1]).toLowerCase();
        for (int i = 0; i < word1.length(); i++) {
            if (lets.indexOf(str1.charAt(i)) != -1)
                list1.add(word1.charAt(i));
        }
        for (int i = 0; i < word2.length(); i++) {
            if (lets.indexOf(str2.charAt(i)) != -1)
                list2.add(word2.charAt(i));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if (list1.size() == list2.size()) 
            return true;
        else 
            return false;
    }
    // 9/10
    public static boolean trouble(long a, long b) {
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        Character ch = null;
        for (int i = 2; i < s1.length(); i++) {
            if ((s1.charAt(i - 2) == s1.charAt(i - 1) && (s1.charAt(i - 1) == s1.charAt(i)))) {
                ch = s1.charAt(i);
                for (int j = 1; j < s2.length(); j++) {
                    if (s2.charAt(j-1) == s2.charAt(j) && (s2.charAt(j) == ch))
                        return true;
                }
            }
        }
        return false;
    }
    public static int countUniqueBooks(String s, char ch) {
        String str = new String();
        int k = 1;
        String [] arr = s.split("[" + ch + "]");
        for (int i = 1; i < arr.length; i+=2) 
            str+=arr[i];
            if (str.length() == 0) 
                k = 0;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i-1) != str.charAt(i)) 
                    k++;
            }
            return k;
    }
}
