package Tasks;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;


public class Task5 {
    public static void main(String[] args) throws Exception {
        System.out.println("Task 1/10");
        System.out.println(encrypt("Hello"));
        System.out.println(decrypt(new int [] {72, 33, -73, 84, -12, -3, 13, -13, -68,}));
        System.out.println("Task 2/10");
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Pawn", "A8", "A7"));
        System.out.println(canMove("Knight", "A4", "B2"));
        System.out.println(canMove("Queen", "C4", "D6"));
        System.out.println(canMove("King", "A8", "B7"));
        System.out.println("Task 3/10");
        System.out.println(canComplete("butl", "beatiful"));
        System.out.println(canComplete("butlz", "beatiful"));
        System.out.println(canComplete("tulb", "beatiful"));
        System.out.println("Task 4/10");
        System.out.println(sumDigProd(16, 28));
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println("Task 5/10");
        System.out.println(sameVowelGroup(new String [] {"toe", "ocelot", "maniac"}));
        System.out.println(sameVowelGroup(new String [] {"hoops", "chuff", "bot", "bottom"}));
        System.out.println("Task 6/10");
        System.out.println(validateCard(123123123123123L));
        System.out.println("Task 7/10");
        System.out.println(numToEng(35));
        System.out.println(numToRus(832));
        System.out.println("Task 8/10");
        System.out.println(getSha256Hash("Hello"));
        System.out.println(getSha256Hash("password123"));
        System.out.println("Task 9/10");
        System.out.println(correctTitle("jOn snOw, kiNg of The north"));
        System.out.println("Task 10/10");
        System.out.println(haxLattice(19));
    }
    // 1/10
    public static String encrypt(String s) {
        int [] arr1 = new int[s.length()];
        int [] arr2 = new int[s.length()];
        for (int i = 0; i < s.length(); i++) 
            arr1[i] = (int) s.charAt(i);
        arr2[0] = arr1[0];
        for (int i = 1; i < arr1.length; i++) 
            arr2[i] = arr1[i] - arr1[i - 1];
        return Arrays.toString(arr2);
    }
    public static String decrypt(int [] array) {
        String s = new String();
        s += (char) array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + array[i];
            s += (char) (array[i]);
        }
        return s;
    }
    // 2/10
    public static boolean canMove(String s, String n, String m) {
        char a1 = n.charAt(0); // "A" 8
        int a2 = n.charAt(1); // A "8"
        int l1 = (int) a1;
        char b1 = m.charAt(0); // "C"3
        int b2 = m.charAt(1); // C "3"
        int l2 = (int) b1;
        if (s.contains("Rook"))  //Ладья
            return ((a1 == b1) || (a2 == b2)); //если равна хотя бы одна коор-та
        if (s.contains("Bishop"))  //Слон
            return Math.abs((a2 - b2) / (l1 - l2)) == 1; //по диагонали, тогда х и у смещаются поровну => -1 или 1
        if (s.contains("Pawn")) //Пешка
            return ((l1 == l2) && (Math.abs(a2 - b2) <= 2)); //координаты х равны, по у = 1 или 2
        if (s.contains("Knight"))  //Конь
            return ((Math.abs(l2 - l1) == 1 && Math.abs(a2 - b2) == 2 // шаг по х = 1, по у = 2
            ||       Math.abs(l2 - l1) == 2 && Math.abs(a2 - b2) == 1)); // шаг по х = 2, по у = 1
        if (s.contains("Queen"))  //Ферзь
            return (Math.abs((a2 - b2) / (l1 - l2)) == 1 //для слона
            ||  ((Math.abs(l1 - l2) == 1 && Math.abs(b2 - a2) == 1))); //для короля
        if (s.contains("King"))  //Король
            return ((Math.abs(l1 - l2) <= 1 && Math.abs(b2 - a2) <= 1)); //есть смещение <= 1 по х и по у
        return false;
    }
    // 3/10
    public static boolean canComplete(String word1, String word2) {
        int k = 0;
        boolean flag = false;
            for (int i = 0; i < word1.length(); i++) {
                flag = false;
                for (int j = k; j < word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        k = word1.indexOf(word1.charAt(i)) + 1;
                        flag = true;
                        break;
                    }
                }
                if (flag == false)
                return false;
            }
        return true;
    }
    // 4/10
    public static int sumDigProd(int ...s) {
        int n = 0;
        for (int k: s)
            n += k;
        int x = n;
        while (n > 9) {
            x = 1;
            while (n > 0) {
                x *= n % 10;
                n /= 10;
            }
            n = x;
        }
        return n;
    }
    // 5/10
    public static ArrayList<String> sameVowelGroup(String [] arr) {
        String lets = "aeiouy";
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        for (int i = 0; i < arr[0].length(); i++) { //гласные в первом слове
            if (lets.indexOf(arr[0].charAt(i)) != -1)
                list1.add(arr[0].charAt(i));
        }
        Collections.sort(list1);
        for (int i = 1; i < list1.size(); i++) { //одинаковые в первом слове
            if ((list1.get(i)).equals(list1.get(i-1))) 
                list1.remove(i-1);
        } 
        for (int i = 0; i < arr.length; i++) { //для каждого слова в исх. массиве
            for (int j = 0; j < arr[i].length(); j++) { 
                if (lets.indexOf(arr[i].charAt(j)) != -1) 
                    list2.add(arr[i].charAt(j));
                Collections.sort(list2);
                for (int n = 1; n < list2.size(); n++) {
                    if ((list2.get(n)).equals(list2.get(n-1))) 
                        list2.remove(n-1);
                }
            }
            if (list1.size() == list2.size()) {
                for (int n = 0; n < list2.size(); n++) {
                    if (list1.get(n) == list2.get(n)) 
                        list3.add(arr[i]);
                    else 
                        break;
                }
            }
            list2.clear();
        }
        for (int i = 1; i < list3.size(); i++) { //одинаковые слова
            if ((list3.get(i)).equals(list3.get(i-1))) 
                list3.remove(i-1);
        }
        return list3;
    }
    // 6/10
    public static boolean validateCard(long n) {
        int s = 0;
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        String st = String.valueOf(n).substring(0, String.valueOf(n).length()-1);
        int k = Integer.valueOf(String.valueOf(n).substring(String.valueOf(n).length()-1));
        if (st.length() < 13 || st.length() > 18)
            return false;
        for (int i = st.length() - 1; i >= 0; i--) 
            list1.add(st.charAt(i));
        for (int i = 0; i < list1.size(); i++) {
            if (i % 2 == 0) 
                list2.add(Character.getNumericValue(list1.get(i)) * 2);
            else 
                list2.add(Character.getNumericValue(list1.get(i)));
        }
        for (int l = 0; l < list1.size(); l++) {
            if (list2.get(l) > 9) 
                list2.set(l, list2.get(l) / 10 + list2.get(l) % 10);
            s += list2.get(l);
        }
        int t = 10 - Integer.valueOf(String.valueOf(s).substring(String.valueOf(s).length()-1));
        return (k == t);
    }
    //7/10
    public static String numToEng(int n) {
        String s = new String();
        int a, b, c;
        Map<Integer, String> nums = new HashMap<Integer, String>();
        nums.put(0, "zero");
        nums.put(1, "one");
        nums.put(2, "two");
        nums.put(3, "three");
        nums.put(4, "four");
        nums.put(5, "five");
        nums.put(6, "six");
        nums.put(7, "seven");
        nums.put(8, "eight");
        nums.put(9, "nine");
        nums.put(10, "ten");
        nums.put(11, "eleven");
        nums.put(12, "twelve");
        nums.put(13, "thirteen");
        nums.put(14, "fourteen");
        nums.put(15, "fifteen");
        nums.put(16, "sixteen");
        nums.put(17, "seventeen");
        nums.put(18, "eighteen");
        nums.put(19, "nineteen");
        nums.put(20, "twenty");
        nums.put(30, "thirty");
        nums.put(40, "forty");
        nums.put(50, "fifty");
        nums.put(60, "sixty");
        nums.put(70, "seventy");
        nums.put(80, "eighty");
        nums.put(90, "ninety");
        nums.put(100, "hundred");
        if (n >= 0 && n <= 20) 
            s = nums.get(n);
        if (n > 20 && n <= 100) {
            a = n % 10;
            b = (n / 10) * 10;
            if (a != 0) 
                s = nums.get(b) + " " + nums.get(a);
            else
                s = nums.get(b);
        }
        if (n > 100 && n < 1000) {
            a = n % 10;
            b = ((n % 100) / 10) * 10;
            c = n / 100;
            if (n % 100 == 0) 
                s = nums.get(c) + " " + nums.get(100);
            else if (a == 0)
                s = nums.get(c) + " " + nums.get(100) + " " + nums.get(b);
            else if (b == 0)
                s = nums.get(c) + " " + nums.get(100) + " " + nums.get(a);
            else 
                s = nums.get(c) + " " + nums.get(100) + " " + nums.get(b) + " " + nums.get(a);
        }
        return s;
    }
    // 7/10 RUS
    public static String numToRus(int n) {
        String s = new String();
        int a, b, c;
        Map<Integer, String> nums = new HashMap<Integer, String>();
        nums.put(0, "ноль");
        nums.put(1, "один");
        nums.put(2, "два");
        nums.put(3, "три");
        nums.put(4, "четыре");
        nums.put(5, "пять");
        nums.put(6, "шесть");
        nums.put(7, "семь");
        nums.put(8, "восемь");
        nums.put(9, "девять");
        nums.put(10, "десять");
        nums.put(11, "одиннадцать");
        nums.put(12, "двенадцать");
        nums.put(13, "тринадцать");
        nums.put(14, "четырнадцать");
        nums.put(15, "пятнадцать");
        nums.put(16, "шестнадцать");
        nums.put(17, "семнадцать");
        nums.put(18, "восемнадцать");
        nums.put(19, "девятнадцать");
        nums.put(20, "двадцать");
        nums.put(30, "тридцать");
        nums.put(40, "сорок");
        nums.put(50, "пятьдесят");
        nums.put(60, "шестьдесят");
        nums.put(70, "семьдесят");
        nums.put(80, "восемьдесят");
        nums.put(90, "девяносто");
        nums.put(100, "сто");
        nums.put(200, "двести");
        nums.put(300, "триста");
        nums.put(400, "четыреста");
        nums.put(500, "пятьсот");
        nums.put(600, "шестьсот");
        nums.put(700, "семьсот");
        nums.put(800, "восемьсот");
        nums.put(900, "девятьсот");
        if (n >= 0 && n <= 20) 
            s = nums.get(n);
        if (n > 20 && n <= 100) {
            a = n % 10;
            b = n;
            if (a != 0) 
                s = nums.get(n) + " " + nums.get(a);
            else
                s = nums.get(n);
        }
        if (n > 100 && n < 1000) {
            a = n % 10;
            b = ((n % 100) / 10) * 10;
            c = n - n % 100;
            if (n % 100 == 0) 
                s = nums.get(c);
            else if (a == 0)
                s = nums.get(c) + " " + nums.get(b);
            else if (b == 0)
                s = nums.get(c) + " " + nums.get(a);
            else 
                s = nums.get(c) + " " + nums.get(b) + " " + nums.get(a);
        }
        return s;
    }
    // 8/10
    public static String getSha256Hash(String s) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("SHA-256");
        byte [] input = s.getBytes();
        byte [] digest = m.digest(input);
        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
        return sha256;
    }
    // 9/10
    public static String correctTitle(String s) {
        String str = new String();
        String [] arr = s.toLowerCase().split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("and") || arr[i].equals("the") || arr[i].equals("of") || arr[i].equals("in")) 
                str += arr[i] + " ";
            else str += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1) + " ";
        }
        return str;
    }
    // 10/10
    public static String haxLattice(int n) {
        int num = 1;
        int i = 1;
        String res = "";
        while (num < n) {
            i++;
            num = 3 * i * (i - 1) + 1; //является ли шестиугольником
        }
        int k = i; //сколько в первой и последней строках
        if (n != num)
            res = "invalid";
        while (k < i * 2 - 1) { //до середины
            for (int a = 0; a < i * 2 - 1 - k; a++)
                res += " "; //колво пробелов = отдаленность от середины
            for (int b = 0; b < k; b++)
                res += "o "; //когда напечатали все пробелы
            res += "\n";
            k++; //на следующей строке +1 "о"
        }
        while (k >= i) { //середина и после
            for (int a = 0; a < i * 2 - 1 - k; a++)
                res += " ";
            for (int b = k; b > 0; b--)
                res += "o ";
            res += "\n";
            k--; //на следующей строке -1 "о"
        }
        return res;
    }
}
