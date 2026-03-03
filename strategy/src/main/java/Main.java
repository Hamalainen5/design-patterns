import java.util.Random;


// Client creates arrays and chooses a strategy
// Uses Sorter as a uniform interface for all algorithms
// measures performance using System.nanoTime()
// Cloning the array ensures each algorithm uses identical data
public class Main {
    public static void main(String[] args) {
        int smallSize = 30;
        int largeSize = 100_000;

        // Generate random arrays
        int[] smallArray = generateRandomArray(smallSize);
        int[] largeArray = generateRandomArray(largeSize);

        // Create strategies
        SortStrategy[] strategies = {new BubbleSort(), new QuickSort(), new MergeSort()};
        String[] strategyNames = {"Bubble Sort", "Quick Sort", "Merge Sort"};

        // Test on small array
        System.out.println("=== Small Array ===");
        for (int i = 0; i < strategies.length; i++) {
            int[] arrCopy = smallArray.clone(); // Clone so each algorithm uses same data
            Sorter sorter = new Sorter(strategies[i]); // Set strategy
            long start = System.nanoTime(); // Start timer
            sorter.sortArray(arrCopy);      // Sort
            long end = System.nanoTime();   // End timer
            System.out.printf("%s took %.2f ms%n", strategyNames[i], (end - start) / 1e6);
        }

        // Test on large array
        System.out.println("\n=== Large Array ===");
        for (int i = 0; i < strategies.length; i++) {
            int[] arrCopy = largeArray.clone(); // Clone array for fair testing
            Sorter sorter = new Sorter(strategies[i]);
            long start = System.nanoTime();
            sorter.sortArray(arrCopy);
            long end = System.nanoTime();
            System.out.printf("%s took %.2f ms%n", strategyNames[i], (end - start) / 1e6);
        }
    }

    // Helper method: generate random integer array
    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 10);
        return arr;
    }
}
