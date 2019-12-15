class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        boolean exists = false;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s && start <= end) {
                if (end-start+1 < length) {
                    length = end-start+1;
                    exists = true;
                }
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return exists?length:0;
    }
}