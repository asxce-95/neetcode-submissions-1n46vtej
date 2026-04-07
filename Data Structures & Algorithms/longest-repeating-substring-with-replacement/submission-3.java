class Solution {
    public int characterReplacement(String str, int k) {
        HashMap<Character, Integer> m = new HashMap();
        char s[] = str.toCharArray();

        int l = 0, r = -1, size = 0;

        for(char c: s){

            m.put(c, m.getOrDefault(c, 0) + 1);
            r++;
            size =  r - l + 1;

            int maxfreq = maxFreq(m);

            if( (size - maxfreq) > k){
                m.put(s[l], m.getOrDefault(s[l], 0) - 1);
                l++;
                size--;
            }

        }
        return size;

    }

    public int maxFreq(HashMap<Character, Integer> m ){
        int freq = Integer.MIN_VALUE;
        for(Map.Entry<Character, Integer> entry: m.entrySet()){
            freq = Math.max(freq, entry.getValue());
        }
        return freq;
    }
}
