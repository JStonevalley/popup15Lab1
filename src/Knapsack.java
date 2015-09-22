import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Erik Ranby and Jonas Stendahl.
 */
public class Knapsack {

    private static boolean kattis = true;

    public static void main(String[] args) {
        Knapsack k = new Knapsack();
        ArrayList<KnapsackCase> cases = k.readInput();
        ArrayList<KnapsackResult> results = k.knapsack(cases);
        for (KnapsackResult result : results) {
            result.print();
        }
    }

    private ArrayList<KnapsackResult> knapsack(ArrayList<KnapsackCase> cases) {
        ArrayList<KnapsackResult> results = new ArrayList<>();

        for (KnapsackCase kCase : cases) {
            int intCapacity = (int)Math.floor(kCase.getCapacity());
            int[] values = kCase.getValues();
            int[] weights = kCase.getWeights();
            int[][] maxValue = new int[kCase.getNumItems()+1][intCapacity+1];
            boolean[][] take = new boolean[kCase.getNumItems()][intCapacity+1];
            // Base case
            for (int j = 0; j < intCapacity; j++) {
                maxValue[0][j] = 0;
            }

            for (int i = 1; i <= kCase.getNumItems(); i++) {
                for (int j = 0; j <= intCapacity; j++) {
                    if (weights[i-1] <= j && maxValue[i-1][j-weights[i-1]] + values[i-1] > maxValue[i-1][j]) {
                        maxValue[i][j] = maxValue[i-1][j-weights[i-1]] + values[i-1];
                        take[i-1][j] = true;
//                        System.err.println("Added item: "+ (i-1));
                    } else {
                        maxValue[i][j] = maxValue[i-1][j];
                        take[i-1][j] = false;
                    }
                }
            }
            System.err.println("Max value: " + maxValue[kCase.getNumItems()][intCapacity]);

            ArrayList<Integer> resultIndices = new ArrayList<>();
            int cap = intCapacity;
            for (int i = kCase.getNumItems()-1; i >= 0; i--) {
                if (take[i][cap]) {
                    resultIndices.add(i);
                    cap = cap - weights[i];
                }
            }
            results.add(new KnapsackResult(resultIndices));

        }
        return results;
    }

    private ArrayList<KnapsackCase> readInput() {
        Kattio io = null;
        try {
            if (kattis) {
                io = new Kattio(System.in);
            } else {
                io = new Kattio(new BufferedInputStream(new FileInputStream("input/knapsack.in")));
            }
        }catch(FileNotFoundException e) {

        }
        ArrayList<KnapsackCase> cases = new ArrayList<>();

        while(io.hasMoreTokens()) {
            double capacity = io.getDouble();
            int items = io.getInt();
            int[] values = new int[items];
            int[] weights = new int[items];
            for (int i  = 0; i < items; i++) {
                values[i] = io.getInt();
                weights[i] = io.getInt();
            }
            cases.add(new KnapsackCase(capacity, values, weights));
        }
        return cases;
    }
}
