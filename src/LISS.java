import java.util.ArrayList;
//Jonas Stendahl & Erik Ranby
public class LISS {
    public static void main(String[] args) {
        LISS liss = new LISS();
    }
    public LISS(){
        Kattio io = new Kattio(System.in);
        while(io.hasMoreTokens()) {
            int seqLength = io.getInt();
            Element[] last = new Element[seqLength + 2];
            for (int i = 0; i < last.length; i++) {
                last[i] = new Element(-1, Integer.MAX_VALUE);
            }
            last[0].value = Integer.MIN_VALUE;
            Element[] elements = new Element[seqLength];
            int l;
            for (int i = 0; i < seqLength; i++) {
                Element element = new Element(i, io.getInt());
                //Find maximum l such that last[l] < element.value
                l = binarySearch(last, element);
                if ((last[l + 1].value == Integer.MAX_VALUE || element.value < last[l + 1].value) && element.value != last[l].value) {
                    last[l + 1].value = element.value;
                    last[l + 1].index = element.index;
                    element.previous = last[l].index;
                    elements[element.index] = element;
                }
            }
            // Backtrack solution to find the indices of the longest sequence.
            int maxIndex = 0;
            for (int i = 1; i < last.length; i++) {
                if (last[i].value == Integer.MAX_VALUE) {
                    maxIndex = last[i - 1].index;
                    break;
                }
            }
            ArrayList<Integer> indices = new ArrayList<>();
            Element temp = elements[maxIndex];
            indices.add(temp.index);
            while (temp.previous >= 0) {
                temp = elements[temp.previous];
                indices.add(temp.index);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = indices.size() - 1; i >= 0; i--) {
                sb.append(indices.get(i));
                sb.append(" ");
            }
            System.out.println(indices.size());
            System.out.println(sb.toString());
        }
    }

    /**
     * A binary search that searches for an interval between values in which the key
     * fits where: key < interval.high && key >= interval.low returns interval.low.
     * @param array array to suggest a position in
     * @param key the key which need suggested position
     * @return the suggested index of the key.
     */
    private int binarySearch(Element[] array, Element key){
        if(key.value > array[array.length-1].value || key.value < array[0].value)
            return -1;
        if (array.length < 10){
            int index = -1;
            for (int i = 0; i < array.length; i++) {
                if (array[i+1].value > key.value && array[i].value <= key.value){
                    return i;
                }
            }
        }
        int low = 0;
        int high = array.length-1;
        int mid = low;
        while (low <= high){
            mid = low + (high-low)/2;
            if(key.value < array[mid+1].value && key.value >= array[mid].value){
                return mid;
            }
            else if (key.value < array[mid+1].value){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
    private class Element{
        public int index;
        public int value;
        public int previous = -1;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
