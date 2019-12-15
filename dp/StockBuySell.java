public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int value:A) {
            if (value < minValue) {
                minValue = value;
            }
            if (value-minValue > maxProfit) {
                maxProfit = value-minValue;
            }
        }
        return maxProfit;
    }
}
