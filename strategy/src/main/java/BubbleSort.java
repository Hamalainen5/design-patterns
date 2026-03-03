// BubbleSort implements SortStrategy
// BubbleSort is simple but slow for large arrays
public class BubbleSort implements SortStrategy{
    @Override
    public void sort (int[] array) {
        int n = array.length;
        // outer loop for each element
        for  (int i = 0; i < n - 1; i++) {
            // inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // swap if the element found is greater than the next element
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
