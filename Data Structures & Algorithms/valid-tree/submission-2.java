class Solution {
    public boolean validTree(int n, int[][] edges) {
        int e = edges.length;
        if(e != n-1){
            return false;
        }

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

        int sum =0 ;

        for(Set<Integer> s: adj){
            sum += s.size();
        }

        if(sum == 2*e){
            dfs(0, adj, visited);
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    return false;
                }
            }

            return true;
        }

        return false;
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
