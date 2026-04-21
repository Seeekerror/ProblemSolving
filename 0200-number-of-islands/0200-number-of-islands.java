class Solution {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean [][] vis = new boolean[m][n];
        int count=0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(grid,i,j,vis);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(char [][] grid, int r, int c, boolean [][] vis){
        if(r < 0 || r >= m || c < 0 || c >= n || vis[r][c] || grid[r][c] == '0') return;

        vis[r][c] = true;
        dfs(grid,r+1,c,vis);
        dfs(grid,r-1,c,vis);
        dfs(grid,r,c+1,vis);
        dfs(grid,r,c-1,vis);
    }
}