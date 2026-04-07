class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    public List<List<Integer>> pacificAtlantic(int[][] h) {
        List<List<Integer>> ans = new ArrayList<>();
        if (h == null || h.length == 0 || h[0].length == 0) return ans;

        int r = h.length, c = h[0].length;
        boolean[][] pac = new boolean[r][c];
        boolean[][] atl = new boolean[r][c];

        // DFS from Pacific borders (top row, left col)
        System.out.println("Start DFS from Pacific borders...");
        for (int i = 0; i < r; i++) {
            dfs(h, i, 0, pac);
        }
        for (int j = 0; j < c; j++) {
            dfs(h, 0, j, pac);
        }

        // DFS from Atlantic borders (bottom row, right col)
        System.out.println("Start DFS from Atlantic borders...");
        for (int i = 0; i < r; i++) {
            dfs(h, i, c - 1, atl);
        }
        for (int j = 0; j < c; j++) {
            dfs(h, r - 1, j, atl);
        }

        // intersection
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pac[i][j] && atl[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        System.out.println("Result: " + ans);
        return ans;
    }

    // mark visited array 'reach' for all cells that can reach the ocean we started from
    private void dfs(int[][] h, int si, int sj, boolean[][] reach) {
        int r = h.length, c = h[0].length;
        Stack<int[]> st = new Stack<>();
        if (reach[si][sj]) return;
        st.push(new int[]{si, sj});
        reach[si][sj] = true;
        System.out.println("DFS start at (" + si + "," + sj + ")");

        while (!st.isEmpty()) {
            int[] cur = st.pop();
            int i = cur[0], j = cur[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + dx[d], nj = j + dy[d];
                if (ni < 0 || nj < 0 || ni >= r || nj >= c) continue;
                if (reach[ni][nj]) continue;
                // move from current to neighbour only if neighbour height >= current height
                // (we're doing reverse flow: from ocean outward uphill)
                if (h[ni][nj] >= h[i][j]) {
                    reach[ni][nj] = true;
                    st.push(new int[]{ni, nj});
                    // debug
                    // System.out.println("  mark (" + ni + "," + nj + ") reachable from start (" + si + "," + sj + ")");
                }
            }
        }
    }
}