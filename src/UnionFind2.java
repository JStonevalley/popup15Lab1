import java.io.*;
// Jonas Stendahl & Erik Ranby
public class UnionFind2 {

    private static boolean kattis = true;

    private int[] parent;
    private int[] rank;

    public UnionFind2(Kattio io) throws IOException {
        int numElements = io.getInt();
        int numOperations = io.getInt();
        long time = System.currentTimeMillis();
        parent = new int[numElements];
        rank = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < numOperations; i++) {
            String operation = io.getWord();
            int elementId1 = io.getInt();
            int elementId2 = io.getInt();
            if (operation.equals("?")) {
                if (find(elementId1, elementId2)) {
                    log.write("yes\n");
                } else {
                    log.write("no\n");
                }
            }
            else if (operation.equals("=")) {
                unite(elementId1, elementId2);
            }
        }
        if (!kattis) {
            log.write((System.currentTimeMillis() - time) + "");
        }
        log.flush();
    }
    private int root(int n) {
        while (n != parent[n]) {
            parent[n] = parent[parent[n]];
            n = parent[n];
        }
        return n;
    }
    public boolean find(int n1, int n2){
        return root(n1) == root(n2);
    }
    public void unite(int n1, int n2){
        int r1 = root(n1);
        int r2 = root(n2);
        if (rank[r1] < rank[r2]){
            parent[r1] = r2;
            rank[r2] += rank[r1];
        }
        parent[r1] = r2;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = null;
        try {
            if (kattis) {
                io = new Kattio(System.in);
            } else {
                io = new Kattio(new BufferedInputStream(new FileInputStream("input/UFmillion")));
            }
        }catch(FileNotFoundException e) {

        }

        UnionFind2 uf2 = new UnionFind2(io);
    }
}
