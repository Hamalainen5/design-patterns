// The context class
// it uses the strategy interface to call the algorithm defined by a concrete strategy

public class Sorter {
    private SortStrategy strategy; // Holds the strategy object

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    // delegate sorting to the chosen strategy
    public void sortArray(int[] array) {
        strategy.sort(array);
    }
}
