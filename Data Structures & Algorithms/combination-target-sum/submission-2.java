class Solution {



    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] nums, int target) {

        combo(nums, 0, nums.length, target, new ArrayList<>());
        return ans;
        
    }

    public int sumList(List<Integer> a){
        int sum = 0;
        for (int i : a){
            sum += i;
        }

        return sum;
    }


    private void combo(int[] nums, int st, int n, int remain, List<Integer> a) {
        //int cur = sumList(a);
    
        if(remain == 0){
            System.out.println(" Final " + a);
            ans.add(new ArrayList<>(a));
            return;
        } else if(remain < 0){
            return;
        }

        for(int i =st ; i < n ; i++){
            a.add(nums[i]);
            combo(nums, i, n, remain - nums[i], new ArrayList<>(a));
            a.remove(a.size() -1 );

        }

        // if(i == n) return;
        // List<Integer> copy = new ArrayList<>(a);

        
        // while (sumList(a) < t){
        //     a.add(nums[i]);
        //     combo(nums, i+1, n, t, new ArrayList<>(a));
        // }
        //  combo(nums, i+1,n, t, copy);


    }
}
