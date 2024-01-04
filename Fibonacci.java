import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
    static BigInteger arr[];

    private static BigInteger calc_fib(int n) {
        if (arr[n] != null) {
            return arr[n];
        }
        if (n <= 1) {
            arr[n] = BigInteger.valueOf(n);
            return arr[n];
        } else {
            arr[n] = calc_fib(n - 2).add(calc_fib(n - 1));
            return arr[n];
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new BigInteger[n + 1];
        System.out.println(calc_fib(n));
    }
}
