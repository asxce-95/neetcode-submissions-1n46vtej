class Solution {
    public String minWindow(String s2, String s1) {

        int n = s1.length();
        int m = s2.length();

        if(n>m){
            return "";
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


        if(verifyHashMaps(f, ref, s1))
            return s2.substring(l, r+1);

        int size = n;
        int ans = 10000;
        int start = 0;
        int end = 0;

        for(int i = r + 1 ; i< m ; i++){
            //f.put(ch[l], f.get(ch[l]) - 1);
            //l++;
            
            f.put(ch[i], f.getOrDefault(ch[i], 0) + 1);
            size = i - l + 1;


                System.out.println("Iteration " + i);

                System.out.println(f);

            while(verifyHashMaps(f, ref, s1)){
                //ans = Math.min(size, ans);

                if(size < ans){
                    start = l;
                    end = i;
                    ans = size;
                }

                System.out.println("start :"+start+ " end: " + i);
                f.put(ch[l], f.get(ch[l]) - 1);


                System.out.println(f);
                l++;
                size--;
            }
        }

        if(ans == 10000)
            return "";
        else
            return s2.substring(start, end+1);
        
    }

    public boolean verifyHashMaps(HashMap<Character, Integer> f, HashMap<Character, Integer> r, String s){

        
        for(char c: s.toCharArray()){
            int val1 = r.get(c);
            int val2 = f.getOrDefault(c, -1);

            if(val1 > val2)
                return false;
        }

        return true;

    }
}
