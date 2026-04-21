class Solution {
    int m;
    int n;
    boolean [][] vis;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    int count = dfs(grid,i,j, vis);
                    ans = Math.max(ans,count);
                }
            }
        }
        return ans;
    }
    int dfs(int [][] grid, int r, int c, boolean [][] vis){
        if(r < 0 || r >= m || c < 0 || c >= n || vis[r][c] || grid[r][c] == 0) return 0;
        int ans = 1;
        vis[r][c] = true;
        ans += dfs(grid,r+1,c,vis);
        ans += dfs(grid,r-1,c,vis);
        ans += dfs(grid,r,c+1,vis);
        ans += dfs(grid,r,c-1,vis);
        return ans;
    }
}