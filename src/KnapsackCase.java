public class KnapsackCase {
    double capacity;
    int[] values;
    int[] weights;
    int numItems;

    public KnapsackCase(double capacity, int[] values, int[] weights) {
        this.capacity = capacity;
        this.values = values;
        this.weights = weights;
        this.numItems = values.length;
    }

    public double getCapacity() {
        return capacity;
    }

    public int[] getValues() {
        return values;
    }

    public int[] getWeights() {
        return weights;
    }

    public int getNumItems() {
        return numItems;
    }
}
