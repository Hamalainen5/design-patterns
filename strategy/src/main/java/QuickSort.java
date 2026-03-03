// QuickSort implements SortStrategy
// Fast on large arrays
public class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Recursive quicksort
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high); // Partition array
            quickSort(array, low, pi - 1);       // Sort left side
            quickSort(array, pi + 1, high);      // Sort right side
        }
    }

    // Partition: pivot is last element, rearrange elements around pivot
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1; // Index of smaller element
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap pivot to correct position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
