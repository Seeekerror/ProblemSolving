class Solution {
    int [][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[grid.length-1][grid[0].length-1] == 1) return 0;
        dp = new int[grid.length][grid[0].length];
        for(int [] row : dp) Arrays.fill(row,-1);
        return solve(grid,0,0);
    }
    int solve(int [][] grid , int i, int j){
        if(i == grid.length-1 && j == grid[0].length-1) return 1;
        if(i >= grid.length || j >= grid[0].length || grid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = solve(grid,i+1,j) + solve(grid,i,j+1);
    }
}