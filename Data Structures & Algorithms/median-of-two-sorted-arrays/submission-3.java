class Solution {
    public double findMedianSortedArrays(int[] b, int[] a) {

        int n = a.length;
        int m = b.length;

        if(n<m){
            return findMedian(a,b);
        } else
            return findMedian(b,a);


        
    }

    public double findMedian(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        int rdr = (n+m)%2;
        int ptn = (n+m+1)/2;

        int h = Math.min(n, ptn);
        int l = 0;


        while( l <= h){

            int mid = (l+h)/2;

            int rem = ptn - mid;

            int l1 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r2 = Integer.MAX_VALUE;


            if(mid > 0 && mid <= n)
                l1 = a[mid-1];
            
            if(mid < n)
                r1 = a[mid];

            if(rem > 0 && rem <= m)
                l2 = b[rem - 1];

            if(rem < m)
                r2 = b[rem];
            

                System.out.println("l1 :" + l1);
                System.out.println("l2 :" + l2);
                System.out.println("r1 :" + r1);
                System.out.println("r2 :" + r2);

            if(l1 <= r2  &&  l2 <= r1){
                System.out.println("l1 :" + l1);
                System.out.println("l2 :" + l2);
                System.out.println("r1 :" + r1);
                System.out.println("r2 :" + r2);

                if(rdr == 0){
                    int sum = Math.max(l1,l2) + Math.min(r1,r2);
                    return (1.0*sum)/2;
                } else {
                    return Math.max(l1,l2);
                }

            }

            if(l1 > r2)
                h = mid - 1;
            else if(l2 > r1)
                l = mid + 1;


        }

        return 0;


        
    }
}
