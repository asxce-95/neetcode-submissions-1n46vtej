class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;


        boolean visited[][] = new boolean[m][n];

        for(int i=0 ; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j == 0 || i == m-1 || j == n-1){
                    if(board[i][j] == 'O' && !visited[i][j]){
                        dfs(i, j, visited, board);
                    }
                }
            }
        }

        pA(visited);


        for(int i=1 ; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }


        
    }

    public void dfs(int i, int j, boolean[][] visited, char[][] board){
        int m = board.length;
        int n = board[0].length;

        if(i<0 || i>=m || j<0 || j>=n){
            return;
        }


        visited[i][j] = true;
        
        int[] dx = {1, 0, -1, 0}; 
        int[] dy = {0, 1, 0, -1};

        for(int d=0; d<4; d++){
            int ni = i + dy[d];
            int nj = j + dx[d];

            if(ni >=0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]){
                if(board[ni][nj] == 'O')
                    dfs(ni, nj, visited, board);
            }
        } 


    }

    public static void pA(boolean[][] arr) {
        for (boolean[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }











}
