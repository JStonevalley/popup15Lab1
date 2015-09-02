import java.util.ArrayList;

public class KnapsackResult {
    ArrayList<Integer> indices;

    public KnapsackResult(ArrayList<Integer> indices) {
        this.indices = indices;
    }

    public ArrayList<Integer> getIndices() {
        return indices;
    }

    public void print() {
        System.out.println(indices.size());
        for (int index : indices) {
            System.out.print(index);
            System.out.print(" ");
        }
        System.out.println();
    }
}
