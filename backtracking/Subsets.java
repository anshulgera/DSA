class Solution {
    public void backtrack(int[] nums, List<List<Integer>> powerset, List<Integer> subset, int start) {
        powerset.add(new ArrayList<>(subset));
        for(int i=start;i<nums.length;i++) {
            subset.add(nums[i]);
            backtrack(nums, powerset, subset, i+1);
            subset.remove(subset.size()-1);
        }
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        // distinct numbers only, powerset should not contain duplicates
        List<List<Integer>> powerset = new ArrayList<>();
        backtrack(nums, powerset, new ArrayList<>(), 0);
        return powerset;
    }
}