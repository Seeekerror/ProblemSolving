class Solution {
    int [][] dp;
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int [] row : dp) Arrays.fill(row,-1);
        return solve(grid,0,0);
    }
    int solve(int [][] grid, int i, int j){
        if(i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        if(i == grid.length-1 && j == grid[0].length-1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = grid[i][j] + Math.min(solve(grid,i+1,j) , solve(grid,i,j+1));
    }
}