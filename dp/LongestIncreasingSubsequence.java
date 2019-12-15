public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        if(A.size() == 1) return 1;
        int[] memo = new int[A.size()];
        for(int i=0;i<A.size();i++) {
            memo[i] = 1;
        }
        
        int maxSoFar = 1;
        for (int i=1;i<A.size();i++){
            for (int j=0;j<i;j++) {
                if(A.get(i) > A.get(j)) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                    maxSoFar = Math.max(maxSoFar, memo[i]);
                }
            }
        }
        return maxSoFar;
    }
}
