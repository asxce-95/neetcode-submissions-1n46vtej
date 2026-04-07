class Solution {

    List<String> ans = new ArrayList();

    public List<String> letterCombinations(String digits) {

        Map<Character, String> keypad = new HashMap<>();
        keypad.put('2', "abc");
        keypad.put('3', "def");
        keypad.put('4', "ghi");
        keypad.put('5', "jkl");
        keypad.put('6', "mno");
        keypad.put('7', "pqrs");
        keypad.put('8', "tuv");
        keypad.put('9', "wxyz");

        char[] d = digits.toCharArray();
        int n = d.length;

        if(n == 0){
            return ans;
        }

        nloop(keypad, d, 0, n, new StringBuilder());

        return ans;



        
    }

    public void nloop(Map<Character, String> keypad, char[] d, int i, int n, StringBuilder sb){

        if(i == n){
            ans.add(sb.toString());
            return;
        }

        String s = keypad.get(d[i]);

        for(char c: s.toCharArray()){
            sb.append(c);
            nloop(keypad, d, i+1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }



    }
}
