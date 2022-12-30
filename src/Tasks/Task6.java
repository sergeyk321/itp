package Tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
        System.out.println("Task 1/10");
        System.out.println(bell(3));
        System.out.println("Task 2/10");
        System.out.println(translateWord("aate"));
        System.out.println(translateWord("have"));
        System.out.println(translateSentence("have ate have"));
        System.out.println("Task 3/10");
        System.out.println(validColor("rgb(0, 20, 20"));
        System.out.println(validColor("rgba(0,42,32,0.0012)"));
        System.out.println("Task 4/10");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String [] {"b"}));
        System.out.println("Task 5/10");
        System.out.println(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit"));
        System.out.println("Task 6/10");
        System.out.println(ulam(10));
        System.out.println("Task 7/10");
        System.out.println(longest("abccbbd"));
        System.out.println("Task 8/10");
        System.out.println(convertToRoman(2));
        System.out.println(convertToRoman(19));
        System.out.println("Task 9/10");
        System.out.println(formula("16 * 10 = 160"));
        System.out.println(formula("15 - 3 = 50"));
        System.out.println("Task 10/10");
        System.out.println(palindromeDescendant(123321));
        System.out.println(palindromeDescendant(123312));
        System.out.println(palindromeDescendant(23336014));
        
    }
    // 1/10
    public static int fact(int k) {
        int fact = 1;
        for (int i = 1; i <= k; i ++)
            fact = fact*i;
        return fact;
    }
    public static int bell(int n) {
        int k = 2; //число сочетаний 1 по 1 и n по n
        for (int i = 1; i < n; i++)
            k += fact(n) / (fact(i) * fact(n-i));
        return k - n;
    }
    // 2/10
    public static String translateWord(String s) {
        String lets = "aeiouyAEIOUY";
        int n = 0;
        if (lets.indexOf(s.charAt(0)) != -1)
            return s + "yay";
        else {
            while (lets.indexOf(s.charAt(n)) == -1) //ищу вхождение гласного
                n++;
            return s.substring(n) + s.substring(0, n) + "ay"; //c гласной до конца, от начала до гласной, +ау
        }
    }
    public static String translateSentence(String sentence) {
        String str = sentence.replace(".", "");
        String [] word = str.split(" ");
        for (int i = 0; i < word.length; i++) 
            word[i] = translateWord(word[i]);
        return String.join(" ", word);
    }
    // 3/10
    public static boolean validColor(String s) {
        if (s.substring(0, 4).contains("rgb(")) 
            s = s.substring(4, s.length() - 1);
        else if (s.substring(0, 5).contains("rgba(")) 
            s = s.substring(5, s.length() - 1);
        String [] arr1 = s.split(",");
        for (int i = 0; i < arr1.length; i++) 
            if (arr1[i].isEmpty()) 
                return false;
        double [] arr2 = new double[arr1.length]; //привели строку к даблу
        for (int i = 0; i < arr1.length; i++) 
            arr2[i] = Double.parseDouble(arr1[i]);
        if (arr2.length == 3) {
            for (int i = 0; i < 2; i++) {
                int b = (int) arr2[i];
                if (b > 255 || b < 0 ) 
                    return false;
            }
        }
        if (arr2.length == 4) {
            for (int i = 0; i < 3; i++) {
                int b = (int) arr2[i];
                if (b > 255 && b < 0) 
                    return false;
            }
            if (arr2[3] >= 0 && arr2[3] <= 1) 
                return true;
        }
        return true;
    }
    // 4/10
    public static String stripUrlParams(String url) {
        return stripUrlParams(url, new String[] { "" });
    }

    public static String stripUrlParams(String url, String [] arr) {
        String s = new String();
        ArrayList<String> list = new ArrayList<>();
        if (url.contains("?")) {
            s = url.substring(url.indexOf("?") + 1);
            url = url.substring(0, url.indexOf("?") + 1);
        }
        else 
            return url;
        String [] arr1 = s.split("&");
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) 
            list.add(arr1[i]);
        for (int i = 1; i < list.size(); i++) { //повторяющиеся
            if (list.get(i).substring(0, 1).equals(list.get(i-1).substring(0, 1))) 
                list.remove(i-1);
        }
        for (int i = 0; i < list.size(); i++) { //данная буква
            if (list.get(i).substring(0, 1).equals(arr[0])) 
                list.remove(i);
        }
        for (int i = 0; i < list.size(); i++) 
            url += list.get(i) + "&";
        return url.substring(0, url.length() - 1); // -&
    }
    // 5/10
    public static String getHashTags(String s) {
        String sl = s.toLowerCase().replace(",", "");
        String [] k = sl.split(" ");
        String [] str = {"", "", ""};
        for (int l = 0; l < k.length; l++) 
            k[l] = '#' + k[l];
        for (int i = 0; i < k.length - 1; i++) {
            for (int j = i + 1; j < k.length; j++) {
                if (k[i].length() >= k[j].length()) {
                    String temp = k[i];
                    k[i] = k[j];
                    k[j] = temp;
                }
            }
        }
        str[0] = k[k.length - 1];
        str[1] = k[k.length - 2];
        str[2] = k[k.length - 3];
        return Arrays.toString(str);
    }
    // 6/10
    public static int ulam(int n){
        if (n < 4)
            return n;
        int [] ulam = new int[n];
        ulam[0] = 1;
        ulam[1] = 2;
        ulam[2] = 3;
        int id = 3;
        int k = 4;
        while(id < n) {
            int count = 0; 
            for (int i = 0; i < id; i++) {
                for (int j = i + 1; j < id; j++)
                    if (ulam[i] + ulam[j] == k)
                        count++;
            }
            if(count == 1) {
                ulam[id] = k;
                id++;
            }
            k++;
        }
        return ulam[n - 1];
    }
    // 7/10
    public static String longest(String s) {
        ArrayList<String> list = new ArrayList<>();
        String a = new String(); //ответ
        String b = new String(); //временное
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i) + "")) { //если переменная уже была
                if (b.length() > a.length()) 
                    a = b;
                b = "";
            } else {
                list.add(s.charAt(i) + "");
                b += s.charAt(i) + "";
                if (b.length() > a.length()) 
                    a = b;
            }
        }
        return a;
    }
    // 8/10
    public static String convertToRoman(int n) {
        if (n == 0)
            return ("N");
        String [] symbols = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int [] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            while (n >= nums[i]) {
                n -= nums[i];
                res.append(symbols[i]);
            }
        }
        return res.toString();
    }
    // 9/10
    public static boolean formula(String str) {
        String [] arr = str.split(" [+-=/*] ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        if (a + b == c)
            return true;
        else if (a - b == c)
            return true;
        else if (a / b == c)
            return true;
        else if (a * b == c)
            return true;
        return false;
    }
    
    //10/10
    public static boolean palindrome(int n) {
        String str = Integer.toString(n);
        String rev = new String();
        for (int i = str.length() - 1 ; i >= 0; i--) 
            rev += str.charAt(i);
        if (str.equals(rev)) 
            return true;
        return false;
    }

    public static int sumNum(int n) {
        String a = Integer.toString(n);
        String b = new String();
        for (int i = 1; i < a.length(); i += 2) {
            int x = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(a.charAt(i-1));
            b += Integer.toString(x);
        }
        return Integer.parseInt(b);
    }

    public static boolean palindromeDescendant(int n) {
        int x = n;
        if (palindrome(n)) 
            return true;
        while (Integer.toString(x).length() % 2 == 0) {
            x = sumNum(x);
            if (palindrome(x)) 
                return true;
        }
        return false;
    }
}
