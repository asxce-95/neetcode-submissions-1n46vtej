class Solution {
    public int findMin(int[] nums) {

        int n = nums.length, l=0 , r = nums.length-1;
        int mid = 0;

        while(l<=r){
            if(nums[l]<nums[r]){
                return nums[l];
            }
            mid = (l+r)/2;
            if(nums[l] <= nums[mid]){
                l = mid +1;
            } else {
                r = mid;
            }
        }

        return nums[mid];
        
    }
}
