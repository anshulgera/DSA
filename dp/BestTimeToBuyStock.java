class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1 || prices.length == 0) return 0;
        int profit = 0;
        int minSoFar = prices[0];
        for(int i=1;i<prices.length;i++) {
            profit = Math.max(profit, prices[i]-minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return profit;
        
    }
}