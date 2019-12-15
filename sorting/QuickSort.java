class Solution {
    public void quickSort(int[] nums, int left, int right) {
        if(left >= right) return;
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot-1);
        quickSort(nums, pivot+1, right);
        return;
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        int i = left-1;
        for(int j=left;j<right;j++) {
            if(nums[j] < pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = nums[right];
        nums[right] = temp;
        return i+1;

    }

    public static void main(String[] args) {
        int[] nums = {2,0,11,213,89,6};
        Solution s = new Solution();
        s.quickSort(nums, 0, nums.length-1);
        for(int i:nums) {
            System.out.print(i+" ");
        }
    }
}