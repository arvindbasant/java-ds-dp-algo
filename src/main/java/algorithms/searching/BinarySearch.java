package algorithms.searching;

public class BinarySearch {

    private int recSearch(int[] arr, int left, int right, int x) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x)
                return mid;
            if (x < arr[mid])
                return recSearch(arr, left, mid - 1, x);
            return recSearch(arr, mid + 1, right, x);
        }
        return -1;
    }


    public int search(int[] arr, int x) {
        return recSearch(arr, 0, arr.length - 1, x);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 45, 56, 78, 90, 231, 567, 789};

        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(arr, 90));
    }
}
