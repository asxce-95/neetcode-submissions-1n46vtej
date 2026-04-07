class Solution {

    Set<List<Integer>> ans = new HashSet();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> list = new ArrayList<>();
        for (int num : candidates) {
            list.add(num);
        }
        Collections.sort(list);

        combo(list, 0, target, new ArrayList<>());
        return new ArrayList(ans);

    }

    public void combo(List<Integer> nums, int st, int t, List<Integer> a){
        if(st >= nums.size()){
            if(t == 0){
                ans.add(new ArrayList(a));
            }
            return;
        }

        a.add(nums.get(st));
        combo(nums, st+1, t-nums.get(st), a);
        a.remove(a.size() - 1);

        combo(nums, st+1, t, a);


    }
}
