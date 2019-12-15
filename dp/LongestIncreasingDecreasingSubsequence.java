public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        if(A.size() == 0) return 0;
        int ans = 0;
        int[] memo1 = new int[A.size()];
        int[] memo2 = new int[A.size()];
        
        for(int i=0;i<A.size();i++) {
            memo1[i] = 1;
            memo2[i] = 1;
        }
        
        for(int i=1;i<A.size();i++) {
            for(int j=0;j<i;j++) {
                if (A.get(i) > A.get(j)) {
                    memo1[i] = Math.max(memo1[i], memo1[j]+1);
                }
            }
        }
        
        for(int i=A.size()-1;i>=0;i--) {
            for(int j=A.size()-1;j>i;j--) {
                if (A.get(i) > A.get(j)) {
                    memo2[i] = Math.max(memo2[i], memo2[j]+1);
                }
            }
        }
        
        for(int i=0;i<A.size();i++) {
            int curr = memo1[i]+memo2[i];
            ans = Math.max(ans, curr);
        }  
        return ans-1;
    }
}
