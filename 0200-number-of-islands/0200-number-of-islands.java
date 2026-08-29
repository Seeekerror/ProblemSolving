class Solution {
    int m;
    int n;
    boolean [][] vis;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[grid.length][grid[0].length];
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(grid,i,j);
                    c++;
                }
            }
        }
        return c;
    }
    void dfs(char [][] grid , int i , int j){
        if(i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || grid[i][j] == '0') return;
        vis[i][j] = true;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}