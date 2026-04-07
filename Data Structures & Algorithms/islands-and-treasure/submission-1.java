class Solution {
    final int INF = 2147483647;
    
    class Cordinates {
        int i;
        int j;

        public Cordinates(int x, int y){
            i = x;
            j = y;
        }

        @Override
        public String toString(){
            return i + " " + j;
        }
    }

    public void islandsAndTreasure(int[][] grid) {


        int r = grid.length;
        int c = grid[0].length;

        
        

        Deque<Cordinates> q = new ArrayDeque<>();


        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 0){
                        boolean visited[][] = new boolean[r][c];
                        // for(int i=0; i<r; i++){
                        //     for(int j=0; j<c; j++){
                        //         visited[i][j] = false;
                        //     }
                        // }

                        addNeighbors(i, j, grid, visited, q);

                        while(!q.isEmpty()){
                            Cordinates curr = q.removeFirst();
                            addNeighbors(curr.i, curr.j, grid, visited, q);
                        }

                 //   }
                }
            }
        }


    }

    public void addNeighbors(int i, int j, int[][] grid, boolean[][] visited, Deque<Cordinates> q){
        visited[i][j] = true;
        if (checkValidCordinates(i+1, j, visited, grid, grid[i][j])) {
            q.addLast(new Cordinates(i+1, j)) ;
        }
        if (checkValidCordinates(i, j+1, visited, grid, grid[i][j])) {
            q.addLast(new Cordinates(i, j+1)) ;
        }
        if (checkValidCordinates(i-1, j, visited, grid, grid[i][j])) {
            q.addLast(new Cordinates(i-1, j)) ;
        }
        if (checkValidCordinates(i, j-1, visited, grid, grid[i][j])) {
            q.addLast(new Cordinates(i, j-1)) ;
        }
                     
    }

    public boolean checkValidCordinates(int i, int j, boolean[][] visited, int[][] grid, int value){
        int r = grid.length;
        int c = grid[0].length;
        if( i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == -1){
            return false;
        }
        if(visited[i][j]){
            return false;
        }

        grid[i][j] = Math.min(value + 1, grid[i][j]);
        return true;
    }

    
}






