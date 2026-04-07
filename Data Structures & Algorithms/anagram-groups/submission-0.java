class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Random rand = new Random();
        String abc = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Integer> m = new HashMap<>();
        for(char c: abc.toCharArray()){
            m.put(c, rand.nextInt(1000)+1);
        }

        HashMap<Integer, List<String>> ans = new HashMap<>();
        for(String s: strs){
            int sum = 0;
            for(char c: s.toCharArray()){
                sum += m.get(c);
            }

            if(ans.containsKey(sum)){
                (ans.get(sum)).add(s);
                System.out.println(" OLD " + ans);
            } else {
                ans.put(sum, new ArrayList<>());
                ans.get(sum).add(s);
                System.out.println("NEW" + ans);
            }

           
        }

        

        List<List<String>> l = new ArrayList<>();
        for(int i : ans.keySet()){
            l.add(ans.get(i));
        }

        return l;
    }
}
