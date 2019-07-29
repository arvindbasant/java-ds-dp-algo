package algorithms.sorting;

public class QuickSort {

    private int[] arr;

    QuickSort(int[] arr) {
        this.arr = arr;
    }

    private void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private int partitionIt(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {
            while (arr[++leftPtr] < pivot)
                ;
            while (rightPtr > 0 && arr[--rightPtr] > pivot)
                ;

            if(leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);

        return leftPtr;
    }

    private void recQuickSort(int left, int right) {
        if (right - left <= 0) // pointer crossed
            return;
        else {
            int pivot = arr[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    public void sort() {
        recQuickSort(0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] input = {23, 32, 11, 78, 36, 9, 54, 8, 1, 3};
        QuickSort qs = new QuickSort(input);
        qs.sort();
        for (int n: input) {
            System.out.println(n);
        }
    }
}
