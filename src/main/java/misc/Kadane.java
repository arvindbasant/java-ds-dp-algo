package misc;

/*
 * Largest Sum Contiguous Subarray
 * { -2, -3, 4, -1, -2, 1, 5, -3 }
 * 4 + (-1) + (-2) + 1 + 5 = 7
 */
public class Kadane {

    static int maxSubArraySum(int a[]) {

        int sum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i = 0; i < a.length; i++) {
            currentSum = currentSum + a[i];
//            if(sum < currentSum) {
//                sum = currentSum;
//            }
            if(currentSum < 0)
                currentSum = 0;
            else if(sum < currentSum)
                sum = currentSum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int input[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(Kadane.maxSubArraySum(input));
    }
}
