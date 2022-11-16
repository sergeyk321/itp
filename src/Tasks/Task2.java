package Tasks;

//import java.lang.Math;
import java.lang.Character;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Task 1/10");
        System.out.println(repeat("mice", 5)) ;
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));         
        
        System.out.println("Task 2/10");
        System.out.println(differenceMaxMin(new int[] {10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(differenceMaxMin(new int[] {44, 32, 86, 19}));

        System.out.println("Task 3/10");
        System.out.println(isAvgWhole(new int[] {1, 3}));
        System.out.println(isAvgWhole(new int[] {1, 2, 3, 4}));
        System.out.println(isAvgWhole(new int[] {1, 5, 6}));
        System.out.println(isAvgWhole(new int[] {1, 1, 1}));
        System.out.println(isAvgWhole(new int[] {9, 2, 2, 5}));

        System.out.println("Task 4/10");
        int sum1 [] = cumulativeSum(new int [] {1, 2, 3});
        int sum2 [] = cumulativeSum(new int [] {1, -2, 3});
        int sum3 [] = cumulativeSum(new int [] {3, 3, -2, 408, 3, 3});
        for (int i : sum1)
            System.out.print(i + " ");
        System.out.println();
        for (int i : sum2)
            System.out.print(i + " ");
        System.out.println();
        for (int i : sum3)
            System.out.print(i + " ");
        System.out.println();

        System.out.println("Task 5/10");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));

        System.out.println("Task 6/10");
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(12)); 

        System.out.println("Task 7/10");
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));

        System.out.println("Task 8/10");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        System.out.println("Task 9/10");
        System.out.println(isPrefix("automation","auto-"));
        System.out.println(isSuffix("arachnophobia","-phobia"));
        System.out.println(isPrefix("retrospect","sub-"));
        System.out.println(isSuffix("vocation","-logy"));

        System.out.println("Task 10/10");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));

    }
    // 1/10
    public static String repeat(String word, int count) {
        String answer = "";
        for (int i = 0; i < word.length(); i++ ) {
            for (int j = 0; j < count; j++ ) {
                answer += word.charAt(i);
            }
        }
    return answer;
    }

    // 2/10
    public static int differenceMaxMin(int[] array) {
        int Max = array[0];
        int Min = array[0];
        for (int index = 0; index < array.length; index++) {
            if (array[index] > Max) {
                Max = array[index];          
            }
            if (array[index] < Min) {
                Min = array[index];
            }
        }
    return Max - Min;
    }
    // 3/10
    public static boolean isAvgWhole(int[] array) {
        int sum = 0;
        int count = 0;
        for (int index = 0; index < array.length; index++) {
            sum += array[index];
            count++;
        }
        if (sum % count == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    // 4/10
    public static int[] cumulativeSum(int[] array) {
        int [] ans = new int[array.length];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            ans[i] = array[i] + sum;
            sum += array[i];
        }
        return ans;
    } 

    // 5/10
    public static int getDecimalPlaces(String value) {
        for (int index = 0; index < value.length(); index++) {
            if (value.charAt(index) == '.') {
                return value.length() - index - 1;
            }
        }
    return 0;
    }

    // 6/10
    public static int Fibonacci(int num) {
        if (num <= 1) {
           return 0;
        } else if (num == 2) {
           return 1;
        } else {
           return Fibonacci(num - 1) + Fibonacci(num - 2);
        }
    }

    // 7/10
    public static boolean isValid(String ind) {
        if (ind.length() < 6) {
            char symbol;
            for (int index = 0; index < ind.length(); index++) {
                symbol = ind.charAt(index);
                if (symbol == ' '  || !Character.isDigit(symbol)) 
                    return false;
            }
        return true;
        } else 
        return false;
        }

    // 8/10
    public static boolean isStrangePair(String word1, String word2) {
        if ((word1 == "") && (word2 == "")) {
            return true;
        } else {
            char First1 = word1.charAt(0);
            char First2 = word2.charAt(0);
            char Last1 = word1.charAt(word1.length() - 1);
            char Last2 = word2.charAt(word2.length() - 1);
            if ((First1 == Last2) && (First2 == Last1)) {
                return true;
            } else 
                return false;
            }
    }

    // 9/10
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.replace("-", ""));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.replace("-", ""));
    }

    // 10/10
    public static int boxSeq(int num) {
        int res = 0;
        if (num == 0) {
            return 0;
        }
            for (int i = 1; i <= num; i++) {
                if (i % 2 == 1) {
                    res += 3;
                }
                else { 
                    res -= 1;
                }
            }
        return res;
    }
}