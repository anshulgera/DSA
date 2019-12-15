/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        int start;
        int end;
        if(newInterval.start > newInterval.end) {
            end = newInterval.start;
            start = newInterval.end;
        } else {
            end = newInterval.end;
            start = newInterval.start;
        }
        for(int i=0;i<intervals.size();i++) {
            int currStart = intervals.get(i).start;
            int currEnd = intervals.get(i).end;
            if(start >= currEnd) {
                // no overlap && curr before interval
                res.add(new Interval(currStart, currEnd));
            } else if(currStart >= end) {
                // no overlap %% curr after interval
                res.add(new Interval(start, end));
                res.add(new Interval(currStart, currEnd));
                start = Integer.MAX_VALUE;
            } else {
                // overlap exists
                start = Math.min(start, currStart);
                end = Math.max(end, currEnd);
            }
        }
        if(start != Integer.MAX_VALUE) {
            res.add(new Interval(start, end));
        }
        return res;
    }
}
