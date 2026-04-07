class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n>m){
            return false;
        }

        int l = 0 , r = n-1;

        HashMap<Character, Integer> f = new HashMap();
        HashMap<Character, Integer> ref = new HashMap();
        char ch[] = s2.toCharArray();

        for(int i=0; i<=r ; i++){
            f.put(ch[i], f.getOrDefault(ch[i], 0) + 1);
        }

        for(char c: s1.toCharArray()){
            ref.put(c, ref.getOrDefault(c, 0) + 1);
        }

        boolean flag = false;
        flag = verifyHashMaps(f, ref, s1);

            if(flag)
                return flag;

        for(int i = r + 1 ; i< m ; i++){
            f.put(ch[l], f.get(ch[l]) - 1);
            l++;
            
            f.put(ch[i], f.getOrDefault(ch[i], 0) + 1);

            flag = verifyHashMaps(f, ref, s1);

            if(flag)
                return flag;
        }

        return flag;
        
    }

    public boolean verifyHashMaps(HashMap<Character, Integer> f, HashMap<Character, Integer> r, String s){

        
        for(char c: s.toCharArray()){
            int val1 = r.get(c);
            int val2 = f.getOrDefault(c, -1);

            if(val1 != val2)
                return false;
        }

        return true;

    }
}
