import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer>{

    // The iterator stores the Fibonacci calculation state
    // Each iterator should work independently
    // If the sequence stored the state, multiple iterators would share the same progress and interface with each other
    // By storing the state in the iterator, each iterator can progress independently without affecting others

    private int previous = 1;
    private int current = 1;
    private int count =  0;
    private int limit;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return count < limit;
    }
    @Override
    public Integer next() {
        if (count == 0 || count == 1) {
            count++;
            return 1;
        }
        int nextValue = previous + current;
        previous = current;
        current = nextValue;
        count++;
        return nextValue;
    }
}
