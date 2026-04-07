class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> s = new Stack<>();
        int n= h.length;
        int right[] = new int[n];
        int left[] = new int[n];

        for(int i=0 ; i<n ; ){
            if(s.isEmpty()){
                s.push(i);
                i++;
                continue;
            }

            int j = s.peek();
            if(h[i] < h[j]){
                right[j] = i-1;
                s.pop(); 
            } else {
                s.push(i);
                i++;
            }
        }

        while(!s.isEmpty()){
            int j = s.peek();
            right[j] = n-1;
            s.pop();
        }

        for(int i=n-1 ; i>=0 ; ){
            if(s.isEmpty()){
                s.push(i);
                i--;
                continue;
            }

            int j = s.peek();
            if(h[i] < h[j]){
                left[j] = i+1;
                s.pop(); 
            } else {
                s.push(i);
                i--;
            }
        }

        while(!s.isEmpty()){
            int j = s.peek();
            left[j] = 0;
            s.pop();
        }

        int area = 0;
        for(int i=0; i<n ; i++){
            int cur = h[i]*(right[i] - left[i] + 1);
            area = Math.max(area, cur);
        }

        return area;

    }
}
