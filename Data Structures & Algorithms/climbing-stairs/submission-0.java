class Solution {

    Map<Integer, Integer> m = new HashMap<>();

    public int climbStairs(int n) {

        if(m.containsKey(n)){

            System.out.println("getting " + n + " " + m);
            return m.get(n);
        }

        if(n <= 0){
            return 0;
        }
        if(n >= 1 && n <= 3){
            return n;
        }

        int ans = climbStairs(n-1) + climbStairs(n-2);

        m.put(n, ans);
        System.out.println("adding " + n + " " + m);

        return ans;
        
        
        
    }
}
