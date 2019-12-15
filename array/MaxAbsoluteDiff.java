// You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
// f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
public class Solution {
    public int maxArr(ArrayList<Integer> A) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<A.size();i++) {
            maxSum = Math.max(maxSum, A.get(i)+i);
            minSum = Math.min(minSum, A.get(i)+i);
            maxDiff = Math.max(maxDiff, A.get(i)-i);
            minDiff = Math.min(minDiff, A.get(i)-i);
        }
        return Math.max(maxSum-minSum, maxDiff-minDiff);
    }
}
