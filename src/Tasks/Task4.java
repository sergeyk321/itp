package Tasks;

import java.util.ArrayList;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Task 1/10");
        System.out.println(Bessie(10, 7, "Hello my name is Bessie and this is my essay"));
        System.out.println("Task 2/10");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((())(()))(()())"));
    }
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
    }

