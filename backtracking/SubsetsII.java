class Solution {
    public void backtrack(int[] nums, List<List<Integer>> powerset, List<Integer> subset, int start) {
        powerset.add(new ArrayList<>(subset));
        for(int i=start;i<nums.length;i++) {
            if (i>start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            backtrack(nums, powerset, subset, i+1);
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Important to sort to avoid duplicate subsets
        Arrays.sort(nums);
        List<List<Integer>> powerset = new ArrayList<>();
        backtrack(nums, powerset, new ArrayList<>(), 0);
        return powerset;
        
    }
}