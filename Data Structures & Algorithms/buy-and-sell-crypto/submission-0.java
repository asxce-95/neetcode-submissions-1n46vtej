class Solution {
    public int maxProfit(int[] p) {

        int max = 0;
        int profit = 0;

        for(int i=p.length - 1 ; i>=0 ; i--) {
            if(p[i]>max){
                max = p[i];
            }

            if((max - p[i]) > profit){
                profit = (max - p[i]);
            }
        }

        return profit;
        
    }
}
