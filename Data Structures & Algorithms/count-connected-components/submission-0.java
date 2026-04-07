class Solution {
    public int countComponents(int n, int[][] edges) {

        int e = edges.length;

        List<Set<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>()); 
        }

        for(int i=0; i<e ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        System.out.println(adj);

        int count = 0 ;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(i, adj, visited);
            }
        }

        

        return count;
    }

    public void dfs(int i, List<Set<Integer>> adj, boolean[] visited ){
        if(visited[i]){
            return;
        }

        visited[i] = true;

        for(int ni: adj.get(i)){
            dfs(ni, adj, visited);
        }
    }
}
