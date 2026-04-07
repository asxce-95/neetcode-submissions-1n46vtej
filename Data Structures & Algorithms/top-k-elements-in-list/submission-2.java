class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        ArrayList<ArrayList<Integer>> f = new ArrayList<>(nums.length+1);



       
       for(int i: nums){
           m.put(i, m.getOrDefault(i,0)+1);
       }

       System.out.println(m);

       for(int i=0 ;i<nums.length+1; i++){
            f.add(new ArrayList<>());
        }

       for(int i: m.keySet()){
        
       System.out.println(f);   
       
       System.out.println(m.get(i));
       
       System.out.println(i);
           f.get(m.get(i)).add(i);
       }
       System.out.println(f);

       int[] ans = new int[k];

       for(int in = nums.length ;( in>0 && k>0); in--){
            for(int val: f.get(in)){
                ans[--k] = val;
                if(k<=0){
                    break;
                }
            }
       }

       return ans;
    }
}
