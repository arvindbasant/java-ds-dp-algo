package dataStructures;

import java.util.Arrays;

public class ArrayProblems {

    public boolean isAnagram(String s1, String s2) {

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        if (s1Arr.length != s2Arr.length)
            return false;

        for (int i = 0; i < s1Arr.length; i++) {
            if (s1Arr[i] != s2Arr[i])
                return false;
        }
        return true;
    }

    // TC: O(n), SC: O(1)
    public boolean isAnagram2(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;
        int value = 0;

        for (int i = 0; i < s1.length(); i++) {
            value = value ^ s1.charAt(i);
            value = value ^ s2.charAt(i);
        }

        return value == 0;

        // XOR will be 0 if
    }

    public boolean isPalindrome(String str) {
        int startIndex = 0;
        int lastIndex = str.length() - 1;

        while (lastIndex > startIndex) {
            if (str.charAt(startIndex++) != str.charAt(lastIndex--))
                return false;
        }
        return true;
    }

    public int maxContinuous1s(int nums[]) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count = 0;
            else
                count++;
            max = count > max ? count : max;
        }
        return max;
    }

    public void rowWithMax1sInMatrix() {

    }

    public void rowWithMax1sInSortedMatrix(int[][] bMatrix) {

        int rowLength = bMatrix.length;
        int colLength = bMatrix[0].length;

        int row = 0;

        for (int i = colLength - 1; i >= 0; i--) {
            if (bMatrix[row][i] == 0) {
                while (bMatrix[row][i] != 1 && row < rowLength - 1) {
                    row++;
                }
            }
        }

        System.out.println("Row With Max 1s In Sorted Matrix:" + row);

    }



    public static void main(String[] args) {
        ArrayProblems ap = new ArrayProblems();
        System.out.println(ap.isAnagram("hello", "olelh"));
        System.out.println(ap.isAnagram2("hello", "olelh"));
        System.out.println(ap.isPalindrome("abba"));

        int[][] bMatrix = {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}};
        ap.rowWithMax1sInSortedMatrix(bMatrix);

    }
}
