class Solution {
    public boolean exist(char[][] board, String word) {

        int n = board.length, m = board[0].length;
        System.out.println(n + " " + m);
        char[] w = word.toCharArray();


        for(int i=0; i<n ; i++){
            for(int j=0; j < m ; j++){
                if(path(board, i, j, n, m, w, 0, new HashSet())){
                    return true;
                }
            }
        }

        return false;
        
    }

    public boolean path(char[][] a, int r, int c, int n, int m, char[] w, int i, Set<List<Integer>> visited){

        if(i == w.length){
            return true;
        }

        if(r >= n || c >= m){
            return false;
        }
        if(r < 0 || c < 0){
            return false;
        }


        System.out.println(" " + i +" " +r + " " + c);

        List<Integer> rc = new ArrayList();
        rc.add(r);
        rc.add(c);

        if(w[i] == a[r][c] && !visited.contains(rc)){
            visited.add(rc);

            System.out.println(" Found " + w[i] + " " + a[r][c] +" index: " + i +" " +r + " " + c);
            if(!path(a, r+1, c, n, m, w, i+1, new HashSet(visited))){
                if(!path(a, r, c+1, n, m, w, i+1, new HashSet(visited))){
                    if(!path(a, r-1, c, n, m, w, i+1, new HashSet(visited))){
                        if(!path(a, r, c-1, n, m, w, i+1, new HashSet(visited))){

                            return false;

                        }
                    }
                }
            }
            return true;
        }
            return false;
        


    }
}
