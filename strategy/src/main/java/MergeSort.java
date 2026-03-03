// efficient for large arrays, divide and conquer approach
public class MergeSort implements SortStrategy{
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);

    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Find the middle point
            mergeSort(array, left, mid); // Sort first half
            mergeSort(array, mid + 1, right); // Sort second half
            merge(array, left, mid, right); // Merge the sorted halves
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1; // Size of left subarray
        int n2 = right - mid; // Size of right subarray

        int [] leftArray = new int[n1];
        int [] rightArray = new int[n2];

        // copy data to temp arrays

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left; // Initial indexes of subarrays and merged array

        // merge back to original array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) array[k++] = leftArray[i++];
            else array[k++] = rightArray[j++];
        }

        // Copy remaining elements
        while (i < n1) array[k++] = leftArray[i++];
        while (j < n2) array[k++] = rightArray[j++];
    }
}
