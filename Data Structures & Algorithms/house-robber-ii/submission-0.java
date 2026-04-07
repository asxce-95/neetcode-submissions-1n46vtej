class Solution {

     public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1){
            return nums[0];
        } 
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        if(n==3){
            return Math.max(
                    nums[0], Math.max(
                        nums[1], nums[2]
                    )
            );
        }

        int a = nums[0] + robbing(nums, 2, n - 2, n,  new HashMap<>());
        int b = nums[1] + robbing(nums, 3, n - 1, n,  new HashMap<>());
        int c = nums[n - 1] + robbing(nums, 1, n - 3, n,  new HashMap<>());

        return Math.max(
            a, Math.max(
                b,c
            )
        );
        
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
