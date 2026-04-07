class Solution {

    Map<Integer, Integer> m = new HashMap<>();

    public int coinChange(int[] coins, int amount) {


        for(int c: coins){
            m.put(c, 1);
        }


        System.out.println(m);


        for(int i=1; i<amount+1 ; i++){

            int mn = Integer.MAX_VALUE;
            boolean flag = false;

            

            for(int c: coins){

                if(c == i){
                    flag = false;
                    break;   
                }

                if(c < i && getValue(i-c) != -1){
                    mn = Math.min(mn, getValue(i-c));
                    flag = true;
                }
            }
            if(flag){
                m.put(i, mn + 1);
            } else{
                m.put(i, getValue(i));
            }

            

        }

        System.out.println(m);

        return getValue(amount);
        


        
    }

    public int getValue(int x){
        if(x==0){
            return 0;
        }

        if(x < 0){
            return -1;
        }

        if(m.containsKey(x)){
            return m.get(x);
        }

        return -1;
    }
}
