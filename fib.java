public class fib {
    public int fibonacciValue(int num) {
        if (num <= 1) {
           return 0;
        } else if (num == 2) {
           return 1;
        } else {
           return fibonacciValue(num - 1) + fibonacciValue(num - 2);
        }
      }
}
