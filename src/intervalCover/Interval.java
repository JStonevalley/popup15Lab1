package intervalCover;

/**
 * Created by jonas on 2015-09-02.
 */
public class Interval {
    private double low;
    private double high;

    public Interval(double low, double high) {
        this.low = low;
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }
}
