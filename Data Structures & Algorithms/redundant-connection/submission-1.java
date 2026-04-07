class Solution {

    Set<List<Integer>> ans = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        

        List<Set<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            adj.add(new HashSet<>()); 
        }

        for(int i=0; i<n ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        System.out.println(adj);

        dfs(1, 0, adj, visited);


        System.out.println(ans);

        for(int i=n-1; i>=0 ; i--){
            if(ans.contains(Arrays.asList(edges[i][0], edges[i][1]))){
                return edges[i];
            }
        }


        return new int[0];
    }

    public int dfs(int i, int parent, List<Set<Integer>> adj, boolean[] visited ){
        visited[i] = true;

        for(int ni: adj.get(i)){
            System.out.println("On Node : " + i + " With parent " + parent +" Looking for "+ ni);
            if(visited[ni] && ni == parent){
                System.out.println("Skipping: --- On Node : " + i + " With parent " + parent +" Looking for "+ ni);
                continue;
            }
            if(visited[ni] && ni != parent){
                System.out.println("Found Cycle on Node : " + i + " With parent " + parent +" Looking for "+ ni);
                ans.add(Arrays.asList(ni, i));
                ans.add(Arrays.asList(i, ni));
                return ni;
            }
            if(!visited[ni]){
                int value = dfs(ni, i, adj, visited);
                if(value == -2){
                    return -2;
                }
                if(value == -1){
                    continue; 
                }
                System.out.println("Taking Edges between : " + i + " and "+ ni + " Here parent " + parent);
                    ans.add(Arrays.asList(i, ni));
                    ans.add(Arrays.asList(ni, i));

                    if(i == value){
                        return -2;
                    }
                    return value;
            }
        }
        return -1;
    }
}
