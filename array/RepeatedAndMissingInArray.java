public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int duplicate = 0;
        int missing = 0;
        long n = A.size();
        long sumRange = (n*(n+1))/2;
        long sumSqRange = (n*(n+1)*(2*n+1))/6;
        long actualSumRange = 0;
        long actualSumSqRange = 0;
        for(int i:A) {
            actualSumRange += (long)i;
            actualSumSqRange += (long)(i)*(long)(i);
        }
        long diff = actualSumRange - sumRange;
        long sum = (actualSumSqRange - sumSqRange)/diff;
        duplicate = (int)(diff+sum)/2;
        missing = (int)(sum - duplicate);
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(duplicate);
        res.add(missing);
        return res;
    }
}
