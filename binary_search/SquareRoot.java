public class Solution {
    public int sqrt(int a) {
        long left = 1;
        long right = a;
        while (left <= right) {
            long mid = left + (right-left)/2;
            if (mid*mid == a) {
                return (int) mid;
            } else if (mid*mid < a) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return (int) right;
    }
}
