class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<s.length() ; i++){
            if(hm.containsKey(s.charAt(i))){ 
                int val = hm.get(s.charAt(i));
                hm.put(s.charAt(i), ++val);
            } else {
                hm.put(s.charAt(i), 1);
            }
        }

        for(Character k : hm.keySet()){
            System.out.println(k + " "+ hm.get(k));
        }

        for(int i=0; i<t.length() ; i++){
            if(hm.containsKey(t.charAt(i)) && (hm.get(t.charAt(i)) > 0)){
                int val = hm.get(t.charAt(i));
                hm.put(t.charAt(i), --val);
            } else {
                return false;
            }
        }

        for(Character k : hm.keySet()){
            System.out.println(k + " "+ hm.get(k));
        }

        return true;

    }
}
