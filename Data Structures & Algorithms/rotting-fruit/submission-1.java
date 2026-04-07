class Solution {



    final int INF = 2147483647;

    class Coordinates {
        int i, j;
        Coordinates(int x, int y) { i = x; j = y; }
        @Override
        public String toString() { return i + " " + j; }
    }


    public int orangesRotting(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        Deque<Coordinates> q = new ArrayDeque<>();

        for(int i = 0 ;i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 2){
                    grid[i][j] = 0;
                    q.addLast(new Coordinates(i, j));
                } else if(grid[i][j] == 1){
                    grid[i][j] = INF;
                } else if(grid[i][j] == 0){
                    grid[i][j] = -1;
                }
            }
        }

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        int time = 0, maxTime =0, dep = 0;
        while(!q.isEmpty()){
            Coordinates curr = q.removeFirst();
            int value = grid[curr.i][curr.j];

            for(int d=0 ; d<4 ; d++){
                int ni = curr.i + dx[d];
                int nj = curr.j + dy[d];
                if(isValidAndUpdate(ni, nj, grid, value)){
                    q.addLast(new Coordinates(ni, nj));
                }

            }

        }

        for(int i = 0 ;i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == INF){
                   return -1;
                } 
                maxTime = Math.max(maxTime, grid[i][j]);
            }
        }

        return maxTime;
        
    }


    private boolean isValidAndUpdate(int i, int j, int[][] grid, int value){
        int r = grid.length, c = grid[0].length;
        if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == 0) return false;

        if(grid[i][j] > value + 1){
            grid[i][j] = value + 1;
            return true;
        }
        return false;
    }
}
