package intervalCover;
import utilities.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class IntervalCover {

    private final static boolean kattis = false;
    public static void main(String [] args) throws FileNotFoundException {
        Kattio io;
        ArrayList<IntervalCoverCase> cases = new ArrayList<>();
        if (kattis) {
            io = new Kattio(System.in);
        }
        else{
            io = new Kattio(new BufferedInputStream(new FileInputStream("input\\inputIntervalCover")));
        }
        while(io.hasMoreTokens()){
            Interval itc = new Interval(io.getDouble(), io.getDouble());
            Interval[] intervals = new Interval[io.getInt()];
            for (int i = 0; i < intervals.length; i++) {
                intervals[i] = new Interval(io.getDouble(), io.getDouble());
            }
            cases.add(new IntervalCoverCase(itc, intervals));
        }
    }

    public ArrayList<IntervalCoverCase> intervalCover(ArrayList<IntervalCoverCase> cases){
        return new ArrayList<>();
    }
}
