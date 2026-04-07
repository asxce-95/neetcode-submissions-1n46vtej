class Solution {
    public int[] dailyTemperatures(int[] t) {

        Stack<Integer> s = new Stack<>();
        int res[] = new int[t.length];

        for(int i =0 ; i<t.length; )   {

            if(s.isEmpty() || t[s.peek()] >= t[i] ){
                s.push(i);
                i++;
                continue;
            }

            if(t[s.peek()] < t[i]){
                res[s.peek()] = i - s.peek();
                s.pop();
            }
        }

        while(s.isEmpty()){
            res[s.peek()] = 0;
            s.pop();
        }

        return res;
    }
}
