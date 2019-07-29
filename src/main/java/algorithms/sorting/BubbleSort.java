package algorithms.sorting;

// both swap and comparison is proportional to n^2
public class BubbleSort {

    private int[] arr;

    BubbleSort(int[] arr) {
        this.arr = arr;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sort() {
        int j = arr.length - 1;
        while (j >= 0) {
            for (int i = 0; i < j; i++)
                if (arr[i] > arr[i + 1])
                    swap(i, i + 1);

            j--;
        }
    }

    public static void main(String[] args) {
        int[] input = {23, 32, 11, 78, 36, 9, 54, 8, 1, 3};
        BubbleSort bs = new BubbleSort(input);
        bs.sort();
        for (int n : input) {
            System.out.println(n);
        }
    }
}
