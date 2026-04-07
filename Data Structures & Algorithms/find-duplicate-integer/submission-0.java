class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int slow = 0;
        int fast = 0;

        while(true){
            slow++;
            fast =fast + 2;

            if(slow == n){
                slow = 0;
            } 
            if(fast == n){
                fast = n - fast;
            } else if(fast > n){
                fast = fast -n;
            }

            if(nums[slow] == nums[fast]){
                return nums[slow];
            }
        }


        
        
    }
}
