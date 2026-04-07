class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i: nums)
            m.put(i, 1);

        int max = 0;

        for(int i: nums){
            if(m.get(i)==0)
                continue;
            int count = 1;
            int ref = i-1;
            while(m.containsKey(ref)){
                m.put(ref, 0);
                count++;
                ref--;
            }
            ref = i+1;
            while(m.containsKey(ref)){
                m.put(ref, 0);
                count++;
                ref++;
            }

            max = (max>count)? max : count;

        }

        return max;
    }
}
