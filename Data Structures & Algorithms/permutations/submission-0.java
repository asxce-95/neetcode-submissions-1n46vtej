class Solution {


    List<List<Integer>> ans= new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {

        Set<Integer> s = new HashSet();

        for(int i : nums){
            s.add(i);
        }

        per(s, nums.length, new ArrayList());
        return ans;

        
        
    }

    public void per(Set<Integer> s, int n, List<Integer> a){

        if(n==0){
            ans.add(new ArrayList(a));
            return;
        } 
        if(n < 0){
            return;
        }

        

        Iterator<Integer> it = s.iterator();
        while (it.hasNext()) {
            int ele = it.next();

            a.add(ele);

            Set<Integer> copy = new HashSet(s);
            copy.remove(ele);
            per(copy, n-1, a);

            a.remove(a.size() - 1);

           

        }
    }
}
