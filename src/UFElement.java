
public class UFElement {

    private int parent;
    private int rank;

    public UFElement(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }

    public int getParent() {
        return parent;
    }

    public int getRank() {
        return rank;
    }
}
