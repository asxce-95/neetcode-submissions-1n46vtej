class Solution {
    public int search(int[] a, int target) {

        int n = a.length;

        int start = 0;
        int end = n - 1;
        int mid = (start + end)/2;
        int ans = -1;

        while(start<=end){
            mid = (start + end)/2;
            System.out.println(start + " " + end + " " + mid);
            if(a[mid] == target){
                ans = mid;
                break;
            }

            if(a[mid] <= a[end]){

                if( a[mid] < target && target <= a[end]){
                    start = mid + 1;
                } else
                    end = mid - 1;


            } else if(a[mid] >= a[start]){

                if( a[start] <= target && target < a[mid]){
                    end = mid - 1;
                } else
                    start = mid + 1;

            }

        }

        return ans;
        
    }
}
