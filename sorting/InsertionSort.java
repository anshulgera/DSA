public class InsertionSort {
    public void insertionSort(int[] nums, int n) {
        for(int i=0;i<n;i++) {
            int curr = nums[i];
            int j = i;

            while(j>0 && curr < nums[j-1]) {
                nums[j] = nums[j-1];
                j = j-1;
            }
            nums[j] = curr;
        }
        return;
    }
    public void printArray(int[] nums, int n) {
        for(int i=0;i<n;i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] nums = {999,1,2,4,99,0,-2};
        InsertionSort s = new InsertionSort();
        s.insertionSort(nums, nums.length);
        s.printArray(nums, nums.length);
    }
}