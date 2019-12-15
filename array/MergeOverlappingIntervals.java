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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval a, Interval b) {
               return a.start-b.start;
           } 
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i=1;i<intervals.size();i++) {
            int currStart = intervals.get(i).start;
            int currEnd = intervals.get(i).end;
            if(end < currStart) {
                res.add(new Interval(start, end));
                start = currStart;
                end = currEnd;
            } else {
                end = Math.max(end, currEnd);
            }
        }
        res.add(new Interval(start, end));
        return res;
        
    }
}
