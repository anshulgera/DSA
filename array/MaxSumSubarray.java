public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        if (A.size() == 0) return 0;
        if (A.size() == 1) return A.get(0);
        int maxSum = Integer.MIN_VALUE;
        int currSum = A.get(0);
        for(int i=1;i<A.size();i++) {
            if (currSum+A.get(i) > A.get(i)) {
                currSum += A.get(i);
            } else {
                currSum = A.get(i);
            }
            maxSum = Math.max(maxSum, Math.max(currSum, A.get(0)));
        }
        return maxSum;
    }
}
