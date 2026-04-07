class Solution {


    public int rob(int[] nums) {

        Map<Integer, Integer> m = new HashMap<>();
        return robbing(nums, 0, nums.length - 1, nums.length, m);
        
    }

    public int robbing(int[] nums, int s, int e, int n, Map<Integer, Integer> m){

        if(s > e){
            return 0;
        }

        if(m.containsKey(s))
            return m.get(s);

        if(s == e){
            return nums[s]; 
        }

        if((e - s + 1) == 2){
            return Math.max(nums[s], nums[s+1]);
        }


        if((e - s + 1) == 3){
            return Math.max(nums[s] + nums[s+2], nums[s+1]);
        }

        int ans = Math.max(
                        nums[s] + robbing(nums, s+2, e, n, m),
                        nums[s+1] + robbing(nums, s+3, e, n, m)
                    );
        
        m.put(s, ans);

        return ans;

    }
}
