package intervalCover;

/**
 * Created by jonas on 2015-09-02.
 */
public class IntervalCoverCase {
    private Interval itc;
    private Interval[] intervals;

    public IntervalCoverCase(Interval itc, Interval[] intervals) {
        this.itc = itc;
        this.intervals = intervals;
    }

    public Interval getItc() {
        return itc;
    }

    public Interval[] getIntervals() {
        return intervals;
    }
}
