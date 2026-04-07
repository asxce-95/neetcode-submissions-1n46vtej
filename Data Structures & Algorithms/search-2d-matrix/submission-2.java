class Solution {
    public boolean searchMatrix(int[][] a, int target) {

        int m = a[0].length;
        int n = a.length;
        int start = 0, end = n-1;
        int mid = 0;
        while(start<=end){
            mid = (start + end)/2;
            if( a[mid][0] == target ){
                return true;
            }
            else if( a[mid][0] < target ){

                if( a[mid][0] < target && target <= a[mid][m-1] ){
                    break;
                }
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        int r = mid;

        start = 0;
        end = m - 1;

        while(start<=end){
            mid = (start + end)/2;
            if( a[r][mid] == target ){
                return true;
            }
            else if( a[r][mid] < target ){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
        
    }
}
