public class Fibonacci_509 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int first = 0, second = 1 , third = 0;
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
    public static void main(String[] args) {
        Fibonacci_509 sol = new Fibonacci_509();

        int n = 10;
        
        System.out.println("Fibonacci of " + n + " is: " + sol.fib(n));;
    }
}
