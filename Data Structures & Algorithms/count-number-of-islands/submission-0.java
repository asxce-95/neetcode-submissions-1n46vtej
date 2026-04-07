class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;

        System.out.println(r);
        System.out.println(c);

        boolean visited[][] = new boolean[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                visited[i][j] = false;
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == '1'){
                    if(visited[i][j] == false){
                        count++;
                        dfs(i, j, r, c, visited, grid);
                    }
                }
            }
        }

        return count;
    }


    public void dfs(int i, int j, int r, int c, boolean[][] visited, char[][] grid){
        if(i>=r || j>=c ){
            return;
        }

        if(i<0 || j<0 ){
            return;
        }

        if(grid[i][j] == '0'){
            return;
        }

        if(visited[i][j]){
            return;
        } else {
            visited[i][j] = true;
        }

        dfs(i+1, j, r, c, visited, grid);
        dfs(i, j+1, r, c, visited, grid);
        dfs(i-1, j, r, c, visited, grid);
        dfs(i, j-1, r, c, visited, grid);
    }
}
