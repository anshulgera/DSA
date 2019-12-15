public class Solution {
    public int minDistance(String A, String B) {
        
        int n = A.length();
        int m = B.length();
        int[][] memo = new int[n+1][m+1];
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<m+1;j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = 0;
                }
                else if (i == 0){
                    memo[i][j] = j;
                } else if (j == 0) {
                    memo[i][j] = i;
                }
                else if (A.charAt(i-1) == B.charAt(j-1)) {
                    memo[i][j] = memo[i-1][j-1];
                } else {
                    memo[i][j] = Math.min(memo[i-1][j-1], Math.min(memo[i-1][j], memo[i][j-1]))+1; 
                }
            }
        }
        return memo[n][m];
    }
}
