package misc;

public class Fibonacci {

    static int fibRec(int n) {
        if (n == 0 || n == 1)
            return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    static int fibDp(int n) {
        int[] arr = new int[n + 2];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        // 0 1 1
        System.out.println(fibRec(3));
        System.out.println(fibDp(4));

    }
}
