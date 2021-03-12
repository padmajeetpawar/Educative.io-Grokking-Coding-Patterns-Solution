package com.educative;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public String toString() {
        return String.format("(" + start + ", " + end + ")");
    }
};

class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> mergedIntervals = new LinkedList<Interval>();
        if (intervals.size() < 2)
            return intervals;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        Iterator<Interval> itr = intervals.iterator();
        Interval firstInterval = itr.next();
        int start = firstInterval.start;
        int end = firstInterval.end;
        //System.out.println(firstInterval.start);

//        while (itr.hasNext()) {
//            firstInterval = itr.next();
//            if(firstInterval.start < end) {
//                end = Math.max(firstInterval.end, end);
//            }else {
//                mergedIntervals.add(new Interval(start, end));
//                start = firstInterval.start;
//                end = firstInterval.end;
//            }
//
//        }
//        mergedIntervals.add(new Interval(start, end));

        for(Interval interval : intervals) {
            if ( mergedIntervals.isEmpty() || mergedIntervals.getLast().end < interval.start) {
                mergedIntervals.add(new Interval(interval.start,interval.end));
            }else {
                mergedIntervals.getLast().end = Math.max(mergedIntervals.getLast().end, interval.end);
            }
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(7, 9));
        input.add(new Interval(2, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}