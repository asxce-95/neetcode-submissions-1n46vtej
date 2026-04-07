class Solution {

    public String getIndex(String s){

        int[] f = new int[26];
        for(char c: s.toCharArray()){
            f[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for(int i=0 ; i<26; i++){
            if(f[i]!=0){
                res.append((char)(i+'a'));
                res.append(f[i]);
                System.out.println(res);
            }
        }

        return res.toString();

    }

    public List<List<String>> groupAnagrams(String[] strs) {
       
        HashMap<String, List<String>> ans = new HashMap<>();
        for(String s: strs){
            String index = getIndex(s);

            if(ans.containsKey(index)){
                ans.get(index).add(s);
                System.out.println(" OLD " + ans);
            } else {
                ans.put(index, new ArrayList<>());
                ans.get(index).add(s);
                System.out.println("NEW" + ans);
            }

           
        }

        

        List<List<String>> l = new ArrayList<>();
        for(String i : ans.keySet()){
            l.add(ans.get(i));
        }

        return l;
    }
}
