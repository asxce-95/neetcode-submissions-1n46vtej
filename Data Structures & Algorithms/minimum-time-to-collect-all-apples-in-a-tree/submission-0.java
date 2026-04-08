class Solution {
    
    Map<Integer, List<Integer>> ed = new HashMap<>();
    Set<Integer> s = new HashSet<>();

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        for (int i = 0; i < hasApple.size(); i++) {
            if (hasApple.get(i)) s.add(i);
        }

        for (int i = 0; i < edges.length; i++) {
            ed.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            ed.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }

        return dfs(0, -1);
    }

    int dfs(int i, int parent) {

        int curSum = 0;

        for (int val : ed.getOrDefault(i, new ArrayList<>())) {
            if (val == parent) continue;

            int childSum = dfs(val, i);

            if (childSum > 0 || s.contains(val)) {
                curSum += childSum + 2;
            }
        }

        return curSum;
    }
}