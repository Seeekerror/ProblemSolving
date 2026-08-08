class Solution {
    public int findCircleNum(int[][] grid) {
        boolean[] vis = new boolean[grid.length];
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            if (!vis[i]) {
                dfs(grid, i, vis);
                c++;
            }

        }
        return c;
    }

    void dfs(int[][] grid, int i, boolean[] vis) {
        if(vis[i]) return;
        vis[i] = true;
        for (int j = 0; j < grid.length; j++) {
            if (!vis[j] && grid[i][j] == 1) {
                dfs(grid, j, vis);
            }
        }
    }
}