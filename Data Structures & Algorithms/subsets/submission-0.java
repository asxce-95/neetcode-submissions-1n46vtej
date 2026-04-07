class Solution {

    List<List<Integer>> ans = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {


        List<Integer> a = new ArrayList();
        ss(nums, 0, nums.length, a);
        return ans;
        
    }

    public void ss(int[] nums, int i, int n, List<Integer> a){

        if(i >= n){
            System.out.println("Final" + a);
            ans.add(new ArrayList<Integer>(a));

            System.out.println("Answer " + ans);
        
        } else {
            System.out.println("NotAdding " + i + a);
            ss(nums, i+1, n, new ArrayList<Integer>(a));
            System.out.println(i);

            a.add(nums[i]);

            System.out.println("adding "+ i + a);
            ss(nums, i+1, n, new ArrayList<Integer>(a));
        }
    }
}
