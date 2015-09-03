import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UnionFind2 {

    private static boolean kattis = true;

    private int[] parent;
    private int[] rank;

    public UnionFind2(Kattio io){
        int numElements = io.getInt();
        int numOperations = io.getInt();

        parent = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < numOperations; i++) {
            String operation = io.getWord();
            int elementId1 = io.getInt();
            int elementId2 = io.getInt();
            if (operation.equals("?")) {
                if (find(elementId1, elementId2)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
            else if (operation.equals("=")) {
                unite(elementId1, elementId2);
            }
        }
    }
    private int root(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }
    public boolean find(int p, int q){
        return root(p) == root(q);
    }
    public void unite(int p, int q){
        int i = root(p);
        int j = root(q);
        if (rank[i] < rank[j]){
            parent[i] = j;
            rank[j] += rank[i];
        }
        parent[i] = j;
    }

    public static void main(String[] args) {
        Kattio io = null;
        try {
            if (kattis) {
                io = new Kattio(System.in);
            } else {
                io = new Kattio(new BufferedInputStream(new FileInputStream("input/knapsack.in")));
            }
        }catch(FileNotFoundException e) {

        }

        UnionFind2 uf2 = new UnionFind2(io);
    }
}
