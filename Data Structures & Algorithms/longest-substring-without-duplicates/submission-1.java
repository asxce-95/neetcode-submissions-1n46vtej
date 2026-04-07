class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        char c[] = s.toCharArray();
        int l = 0;

        HashMap<Character, Integer> m = new HashMap<>();

        int curr = 0;
        int startIndex = 0;
        for(int i=0 ; i<c.length ; i++){
            if(m.containsKey(c[i]) && m.get(c[i])>=startIndex){
                if(curr>l){
                    l= curr;
                }
                curr = i - m.get(c[i]);
                startIndex = m.get(c[i])+1;
                
                m.put(c[i], i);
            } else {
                curr++;
                m.put(c[i], i);
            }

            System.out.println(" " + startIndex + " " + curr +" " + l + " " + i);

        }

        if(curr>l){
                    l= curr;
                }

        return l;


    }
}
