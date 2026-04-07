class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ss(nums, 0, new ArrayList<>());
        return ans;
    }

    private void ss(int[] nums, int i, List<Integer> a) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(a));
            return;
        }

        // Choice 1: don't include nums[i]
        ss(nums, i + 1, a);

        // Choice 2: include nums[i]
        a.add(nums[i]);
        ss(nums, i + 1, a);
        a.remove(a.size() - 1); // backtrack
    }
}
