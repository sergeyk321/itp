package Tasks;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Task 1/10");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));

        System.out.println("Task 2/10");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));

        System.out.println("Task 3/10");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));

        System.out.println("Task 4/10");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));

        System.out.println("Task 5/10");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("EAECEE"));
        System.out.println(isValidHexCode("#5478422"));
        System.out.println(isValidHexCode("#5Z8422"));
        System.out.println(isValidHexCode("#!123ABC"));

        System.out.println("Task 6/10");
        System.out.println(same(new int [] {1, 3, 4, 4, 4}, new int [] {2, 5, 7}));
        System.out.println(same(new int [] {9, 8, 7, 6}, new int [] {4, 4, 3, 1}));

    }
    // 1/10
    public static int solutions(int a, int b, int c) {
        int d = b*b-4*a*c;
        if (d > 0)
        return 2;
        else if (d == 0)
        return 1;
        else
        return 0; 
    } 

    // 2/10
    public static int findZip(String s) {
        if (s.length() < 5)
            return -1;
        boolean first = false;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 2) == 'z' && s.charAt(i - 1) == 'i' && s.charAt(i) == 'p') {
                if (first == true) 
                    return i - 2;
                first = true;
            }
        }
        return -1;
    }

    // 3/10
    public static boolean checkPerfect(int a) {
        int sum = 0;
        for (int i = 1; i < a; i++) {
            if (a%i==0) 
                sum += i;
        }
        if (sum==a) 
            return true;
        else
        return false;
    }
    // 4/10
    public static String flipEndChars(String s) {
        char firstsy = s.charAt(0);
        char lastsy = s.charAt(s.length()-1);
        char [] ch = s.toCharArray();
        if (firstsy == lastsy) 
            return "Two's a pair";
        else if (s.length() < 2){
            return "Mismatched";
        }
        else {
            char temp = ch[0];
            ch[0] = ch[ch.length-1];
            ch[ch.length-1] = temp;
            return String.valueOf(ch);
        }
    }
    // 5/10
    public static boolean isValidHexCode(String s) {
        if (!(s.length() == 7 && s.charAt(0) == '#'))
            return false;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
        if ((c < '0' || c > '9') && (c < 'A' || c > 'F'))
            return false;
        }
        return true;
    }
    // 6/10
    public static boolean same(int [] arr1, int [] arr2) {
        int count1 = 0;
        int unic1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            unic1++;
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] == arr1[j]) {
                    count1++;
                    break;
                }
            }
        }
        int count2 = 0;
        int unic2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            unic2++;
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[i] == arr2[j]) {
                    count2++;
                    break;
                }
            }
        }
        if (unic1 - count1 == unic2 - count2) 
        return true;
        else
        return false;
    }
}
