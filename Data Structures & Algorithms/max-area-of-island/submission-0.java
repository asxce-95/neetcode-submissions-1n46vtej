class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0, maxArea = 0;
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
                if(grid[i][j] == 1){
                    if(visited[i][j] == false){
                        area = dfs(i, j, r, c, visited, grid);
                        if(area > maxArea){
                            maxArea = area;
                        }
                    }
                }
            }
        }

        return maxArea;
    }

    public int dfs(int i, int j, int r, int c, boolean[][] visited, int[][] grid){
        if(i>=r || j>=c ){
            return 0;
        }

        if(i<0 || j<0 ){
            return 0;
        }

        if(grid[i][j] == 0){
            return 0;
        }

        if(visited[i][j]){
            return 0;
        } else {
            visited[i][j] = true;
        }

        int right = dfs(i+1, j, r, c, visited, grid);
        int down = dfs(i, j+1, r, c, visited, grid);
        int up = dfs(i-1, j, r, c, visited, grid);
        int left = dfs(i, j-1, r, c, visited, grid);

        int area = 1 + right + left + up + down;

        return area;

    }
}
