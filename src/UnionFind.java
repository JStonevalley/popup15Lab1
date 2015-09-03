import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UnionFind {

    private static boolean kattis = true;

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

        UnionFind uf = new UnionFind();
        uf.unionFind(io);
    }

    private void unionFind(Kattio io) {
        int numElements = io.getInt();
        int numOperations = io.getInt();
        UFElement[] elements = new UFElement[numElements];
        // Create starting element with rank 0
//        for (int i = 0; i < numElements; i++) {
//            elements[i] = new UFElement(i, 0);
//        }

        for (int i = 0; i < numOperations; i++) {
            String operation = io.getWord();
            int elementId1 = io.getInt();
            int elementId2 = io.getInt();
            if (operation.equals("?")) {
                if (findRoot(elements, elementId1) == findRoot(elements, elementId2)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
            else if (operation.equals("=")) {
                union(elements, elementId1, elementId2);
            }
        }
    }

    private int findRoot(UFElement[] elements, int elementId) {
        checkAndCreateElement(elements, elementId);
        if (elements[elementId].getParent() == elementId) {
            return elementId;
        } else {
            elements[elementId] = new UFElement(findRoot(elements, elements[elementId].getParent()), elements[elementId].getRank());
            return elements[elementId].getParent();
//            return findRoot(elements, elements[elementId].getParent());
        }
    }

    private void union(UFElement[] elements, int elementId1, int elementId2) {
        int root1 = findRoot(elements, elementId1);
        int root2 = findRoot(elements, elementId2);
        if (root1 == root2) {
            return;
        }

        if (elements[root1].getRank() > elements[root2].getRank()) {
            elements[root2] = new UFElement(root1, elements[root2].getRank());
        }
        else if (elements[root1].getRank() < elements[root2].getRank()) {
            elements[root1] = new UFElement(root2, elements[root1].getRank());
        }
        else {
            elements[root1] = new UFElement(root2, elements[root1].getRank());
            elements[root2] = new UFElement(root2, elements[root2].getRank()+1);
        }

//        elements[root1] = new UFElement(root2, 0);
    }

    private void checkAndCreateElement(UFElement[] elements, int elementId) {
        if (elements[elementId] == null) {
            elements[elementId] = new UFElement(elementId, 0);
        }
    }


}
