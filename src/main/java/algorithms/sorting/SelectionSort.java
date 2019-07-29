package algorithms.sorting;

public class SelectionSort {
    private int[] arr;

    SelectionSort(int[] arr) {
        this.arr = arr;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sort() {
        int j = 0;
        while (j < arr.length) {
            int minIndex = j;
            for (int i = j; i < arr.length; i++)
                if (arr[i] < arr[minIndex])
                    minIndex = i;

            swap(j, minIndex);
            j++;
        }
    }

    public static void main(String[] args) {
        int[] input = {23, 32, 11, 78, 36, 9, 54, 8, 1, 3};
        SelectionSort bs = new SelectionSort(input);
        bs.sort();
        for (int n : input) {
            System.out.println(n);
        }
    }

}
