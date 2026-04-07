class Solution {
    public int[] twoSum(int[] a, int target) {
        int ans[] = new int[2];

        for(int i =0,j=a.length-1 ; i<j ;){
            int sum = a[i]+a[j];
            if(sum==target){
                ans[0]= i+1;
                ans[1]= j+1;
                return ans;
            }
            else if(sum>target){
                j--;
            } else {
                i++;
            }
        }

        return ans;
        
    }
}
