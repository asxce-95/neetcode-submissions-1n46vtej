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


    private void combo(int[] nums, int i, int n, int t, List<Integer> a) {
        int cur = sumList(a);
    
        if(cur == t){
            System.out.println(" Final " + a);
            ans.add(new ArrayList<>(a));
            return;
        } else if(cur > t){
            return;
        }
        if(i == n) return;

        //combo(nums, i+1, n, cur, t, a);

        List<Integer> copy = new ArrayList<>(a);

        
        while (sumList(a) < t){
            //sum = sum + nums[i];
            a.add(nums[i]);
            System.out.println(" Repeat " + a);
            combo(nums, i+1, n, t, new ArrayList<>(a));

            System.out.println(" reloop? " + a);
        }

            System.out.println(" Comming out a : " + a);
            System.out.println(" Comming out copy :" + copy);
         combo(nums, i+1,n, t, copy);


        // int sum = cur;
        // while(sum < t){
        //     sum = sum + nums[i];
        //     a.add(nums[i]);
        //     System.out.println(" Repeat " + a);
        //     combo(nums, i, n, sum, t, new ArrayList<>(a));
        //     a.remove(a.size() - 1);
        // }

    }
}
