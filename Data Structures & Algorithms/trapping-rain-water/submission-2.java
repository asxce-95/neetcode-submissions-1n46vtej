class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int s[] = new int[n];
        int e[] = new int[n];

        
        int si=1,ei=n-2;

        int temp = h[0];
        for(int i=0;i<n;i++){
            if(h[i]>temp){
                temp = h[i];
            }
            s[i] = temp;
        }

        for(int i=0;i<n;i++){
            System.out.print(s[i] + " ");
        }
        System.out.println();
        
        temp = h[n-1];
        for(int i=n-1;i>=0;i--){
            if(h[i]>temp){
                temp = h[i];
            }
            e[i] = temp;
        }
        
        
        for(int i=0;i<n;i++){
            System.out.print(e[i] + " ");
        }
        System.out.println();

        for(int i=1 ; i<n ; i++){
            if(h[i]<h[i-1]){
                si = i;
                break;
            }
        }

        for(int i=n-2 ; i>=0 ; i--){
            if(h[i]<h[i+1]){
                ei = i;
                break;
            } 
        }


        System.out.println(si + " " + ei);
        if((ei-si )<0){
            return 0;
        }
        int area= 0;

        for(int i = si; i<=ei ; i++){
            area = area + ((s[i] < e[i]) ? (s[i] - h[i]) : (e[i] - h[i]));
        }

        return area;

    }
}
