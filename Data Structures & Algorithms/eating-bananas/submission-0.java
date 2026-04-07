class Solution {

    public int soln(int[] p, int k, int n){
        int ans = 0;
        for(int i=0; i<n ;i++){
            ans += Math.ceil((1.0*p[i])/k);
        }
        return ans;
    }

    public int getMax(int[] p, int n){
        int ans = 0;
        for(int i=0; i<n ;i++){
            ans = Math.max(ans,p[i]);
        }
        return ans;
    }

    public int minEatingSpeed(int[] p, int h) {
        int n = p.length;
        int m = getMax(p, n);
        
        int l=1, r=m;
        int lastAns = 1;

        while(l <= r){
            int mid = (l+r)/2;
            int ans = soln(p, mid, n);
            if(ans > h){
                l = mid + 1;
            } else {
                r = mid - 1;
                lastAns = mid;
            }
        }

        return lastAns;

    }
}
