package Tasks;

//import java.lang.Math;
import java.lang.Character;

public class Task2 {
    public static void main(String[] args) {
        /*System.out.println("Task 1/10");
        System.out.println(repeat("mice", 5)) ;*/         
        
        System.out.println("Task 2/10");
        System.out.println(differenceMaxMin(new int[] {10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(differenceMaxMin(new int[] {44, 32, 86, 19}));

        System.out.println("Task 3/10");
        System.out.println(isAvgWhole(new int[] {1, 3}));
        System.out.println(isAvgWhole(new int[] {1, 2, 3, 4}));
        System.out.println(isAvgWhole(new int[] {1, 5, 6}));
        System.out.println(isAvgWhole(new int[] {1, 1, 1}));
        System.out.println(isAvgWhole(new int[] {9, 2, 2, 5}));

    /*     System.out.println("Task 4/10");
        System.out.println(cumulativeSum(new int[] {1, 2, 3}));
        System.out.println(cumulativeSum(new int[] {1, -2, 3}));
        System.out.println(cumulativeSum(new int[] {3, 3, -2, 408, 3, 3})); */

        System.out.println("Task 5/10");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));

        /*System.out.println("Task 6/10");
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(12)); */

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

        System.out.println("Task 10/10");

    }
    // 1/10
    /* public static String repeat(String word, int count) {
        String answer = "";
    return answer;
    } */

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
    /*  public static int cumulativeSum(int[] array) {
        int pred = 0;
        int index = 0;
        int[] newArray = new int[array.length];
        for(index = 0; index < array.length; index++) {
            newArray[index] = array[index];
            }   
    return newArray[index];
    } */

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
    /*public static int Fibonacci(int number) {
        long[] fib = new long[number];
        fib[0] = 0;
        fib[1] = 1;
        for (int index = 2; index <= number; index++) {
            fib[index] = fib[index - 1] + fib[index - 2];
        }
    return fib[number];
    }*/

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
            int n1 = word1.length();
            int n2 = word2.length();
            char First1 = word1.charAt(0);
            char First2 = word2.charAt(0);
            char Last1 = word1.charAt(n1 - 1);
            char Last2 = word2.charAt(n2 - 1);
            if ((First1 == Last2) && (First2 == Last1)) {
                return true;
            } else 
                return false;
            }
    }
    

    // 9/10
    /*public static isPrefix(String word, String prefix-) {
        int pr = word.length();
        String prefix = 
    }
    }*/
}

