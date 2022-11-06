package Tasks;
public class Task1 {
    public static void main(String[] args) {
        System.out.println("Task 1/10");
        System.out.println(remainder(1, 3));
        System.out.println(remainder(3, 4));
        System.out.println(remainder(-9, 45));
        System.out.println(remainder(5, 5));

        System.out.println("Task 2/10");
        System.out.println(triArea(3, 2));
        System.out.println(triArea(7, 4));
        System.out.println(triArea(10, 10));

        System.out.println("Task 3/10");
        System.out.println(animals(2, 3, 5));
        System.out.println(animals(1, 2, 3));
        System.out.println(animals(5, 2, 8));

        System.out.println("Task 4/10");
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(profitableGamble(0.9, 1, 2));

        System.out.println("Task 5/10");
        System.out.println(operation(24, 15, 9));
        System.out.println(operation(24, 26, 2));
        System.out.println(operation(15, 11, 11));

        System.out.println("Task 6/10");
        System.out.println(ctoa('A'));
        System.out.println(ctoa('m'));
        System.out.println(ctoa('['));
        System.out.println(ctoa('\\'));

        System.out.println("Task 7/10");
        System.out.println(addUpTo(3));
        System.out.println(addUpTo(10));
        System.out.println(addUpTo(7));

        System.out.println("Task 8/10");
        System.out.println(nextEdge(8, 10));
        System.out.println(nextEdge(5, 7));
        System.out.println(nextEdge(9, 2));

        System.out.println("Task 9/10");
        System.out.println(sumOFCubes(new int[] {3, 4, 5}));
        System.out.println(sumOFCubes(new int[] {2}));
        System.out.println(sumOFCubes(new int[] {}));

        System.out.println("Task 10/10");
        System.out.println(abcmath(42, 5, 10));
        System.out.println(abcmath(5, 2, 1));
        System.out.println(abcmath(1, 2, 3));

        System.out.println("java".charAt(0));

    }
    // 1/10    
    public static int remainder(int firstNumb, int secondNumb) {
        return firstNumb % secondNumb;
    }
    // 2/10
    public static int triArea(int base, int height) {
        return base * height / 2;
    }
    // 3/10
    public static int animals(int chickens, int cows, int pigs) {
        return chickens * 2 + cows * 4 + pigs * 4; 
    }
    // 4/10
    public static boolean profitableGamble(double prob, int prize, int pay) {
        if (prob * prize > pay) {
            return true;
        } else {
            return false;
        }
    }
    // 5/10
    public static String operation(int N, int a, int b) {
        String op = "none";
        if (a + b == N) {
            op = "added";
        }
        if (a * b == N) {
            op = "multiplied";
        }
        if (a - b == N || b - a == N) {
            op = "substracted";
        }
        if (a / b == N || b / a == N) {
            op = "divided";
        }
        return op;
    }
    // 6/10
    public static int ctoa(char symbol) {
        return (int) symbol;
    }
    // 7/10
    public static int addUpTo(int last) {
        int sum = 0;
            for (int i = 0; i <= last; i++) {
                sum += i;
            }
        return sum;
    }
    // 8/10
    public static int nextEdge(int First, int Second) {
        return First + Second - 1;
    }
    // 9/10
    public static int sumOFCubes(int[] array) {
        int sum = 0;
        for (int index = 0; index < array.length; index++) {
            sum += array[index] * array[index] * array[index];
        }
        return sum;
    }
    // 10/10
    public static boolean abcmath(int a, int b, int c) {
        for (int i = 0; i < b; i++) {
            a += a;
        }
        if (a % c == 0) {
            return true;
        } else {
            return false;
        } 
    }
}