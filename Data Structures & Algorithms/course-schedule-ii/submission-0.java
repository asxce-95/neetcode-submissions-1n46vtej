class Solution {

    Set<Integer> courses = new HashSet<>(); 
    List<Integer> ans = new ArrayList<>();
    

    public int[] findOrder(int n, int[][] prq) {
        if(prq.length == 0){
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            return arr;
        }

        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i< prq.length ; i++){
            adj.get(prq[i][0]).add(prq[i][1]);
        }

        for(int i = 0; i< n ; i++){
            if(adj.get(i).isEmpty()){
                courses.add(i);
                ans.add(i);
            }
        }

        System.out.println(adj);

        for(int i=0 ; i<n ; i++){
            pa(visited);
            if(!courses.contains(i) && !visited[i]){
                dfs(i, n, adj, visited);
            }
        }


        System.out.println(courses);

        if(courses.size() >= n){
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = ans.get(i);
            }
            return arr;
        }
        return new int[0];
        
    }

    public boolean dfs(int i, int n, List<List<Integer>> adj, boolean[] visited ){
        if(courses.contains(i)){
            return true;
        }

        if(visited[i]){
            return false;
        } else {
            System.out.println("Marking True: "+ i );
            visited[i] = true;
        }


        boolean finalValue = true;

        for(int ni: adj.get(i)){
            boolean value = dfs(ni, n, adj, visited);
            finalValue = finalValue && value;
        }

        if(finalValue){
            courses.add(i);
            ans.add(i);
        }

        return finalValue;


    }

    void pa(boolean[] arr) {
        for (boolean num : arr) {
            System.out.print(num + " ");
        }
        System.out.println(); // new line
    }
}
