public class Solution {
    public int climbStairs(int A) {
        if (A == 0) return 0;
        if (A == 1) return 1;
        if (A == 2) return 2;
        int[] memo = new int[A+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for (int i=3;i<=A;i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[A];
    }
}
