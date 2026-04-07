class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[2];

        for(int i=0 ; i<nums.length ; i++)
            hm.put(nums[i], i);

        
        for(int i=0 ; i<nums.length ; i++){
            int tar = target - nums[i];
            if(hm.containsKey(tar)){
                int end = hm.get(tar);
                if(i<end){
                    ans[0] = i;
                    ans[1] = hm.get(tar);
                    return ans;
                }
            }

        }

        // for(int key: hm.keySet()){
        //     int tar = target - key;
        //     if(hm.containsKey(tar)){
        //         int start = hm.get(tar);
        //         int end = hm.get(key);

        //         ans[0] = (start < end) ? start : end;
        //         ans[1] = (start > end) ? start : end;
        //         return ans;
        //     }
        // }

        return ans;
    }
}
