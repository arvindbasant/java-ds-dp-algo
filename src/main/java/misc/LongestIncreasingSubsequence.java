package misc;

public class LongestIncreasingSubsequence {

    static int lisRec(int[] arr, int n) {

        if(n == 1)
            return 1;

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is "
                + lisRec(arr, n) + "\n");
    }
}
