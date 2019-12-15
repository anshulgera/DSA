public class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] memo = new int[n][m];
        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = A.get(i).get(j);
                } else if (i == 0) {
                    memo[i][j] = memo[i][j-1] + A.get(i).get(j);
                } else if (j == 0) {
                    memo[i][j] = memo[i-1][j] + A.get(i).get(j);
                } else {
                    memo[i][j] = Math.min(memo[i-1][j], memo[i][j-1]) + A.get(i).get(j);
                }
            }
        }
        return memo[n-1][m-1];
    }
}
