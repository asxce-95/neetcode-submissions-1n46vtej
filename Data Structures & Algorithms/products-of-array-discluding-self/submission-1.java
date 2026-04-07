class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] l = new int[nums.length];
        int[] r = new int[nums.length];

        for(int i =0 ; i<nums.length; i++){
           l[i] = (i==0)? nums[i] : l[i-1]*nums[i];
        }
        
        for(int i = nums.length -1 ; i>=0; i--){
            r[i] = (i == (nums.length -1)) ? nums[nums.length -1] : r[i+1]*nums[i] ;
        }
        for(int i: l)
            System.out.print(i + " ");

        System.out.println();
         for(int i: r)
            System.out.print(i + " ");

        for(int i =0 ; i<nums.length; i++){
            if(i==0){
                nums[i] = r[i+1];
            } else if(i == (nums.length -1)){
                nums[i] = l[nums.length -2];
            } else
                nums[i] = l[i-1]*r[i+1];
        }
        return nums;
    }
}  
