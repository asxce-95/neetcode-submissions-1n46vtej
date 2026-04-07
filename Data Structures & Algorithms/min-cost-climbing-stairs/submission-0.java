class Solution {

    Map<Integer, Integer> m = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {

        return c(cost, cost.length);
        
    }


    public int c(int[] cost, int n){
        if(m.containsKey(n)){
            return m.get(n);
        }
        if(n <= 1){
            return 0;
        }

        if(n == 2){
            return Math.min(cost[n-1], cost[n-2]);

        }

        int ans = Math.min(
                cost[n-1] + c(cost, n-1),
                cost[n-2] + c(cost, n-2)
            );

        m.put(n, ans);

        return ans;
    }
}
