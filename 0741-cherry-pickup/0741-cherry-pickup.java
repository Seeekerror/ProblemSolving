class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int [][][] dp = new int [n][n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                for(int k = 0; k < n; k++)
                        dp[i][j][k] = -1;

        int ans=solve(grid,0,0,0,dp);
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
    int solve(int[][] grid , int r1, int c1, int r2, int [][][] dp){
        int n = grid.length;
        int c2 = r1 + c1 - r2;
        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }
        if(r1 == n-1 && c1 == n-1) return grid[r1][c1];

        int cherry;
        if(r1 == r2 && c1 == c2){
            cherry = grid[r1][c1];
        }else{
            cherry = grid[r1][c1] + grid[r2][c2];
        }
        if(dp[r1][c1][r2] != -1) return dp[r1][c1][r2];
        int f = solve(grid,r1+1,c1,r2+1,dp);
        int s = solve(grid,r1+1,c1,r2,dp);
        int t = solve(grid,r1,c1+1,r2,dp);
        int f4 = solve(grid,r1,c1+1,r2+1,dp);

        int max = Math.max(Math.max(f,s),Math.max(t,f4));

        if(max == Integer.MIN_VALUE){
            return dp[r1][c1][r2] = Integer.MIN_VALUE;
        }
        return dp[r1][c1][r2] = max+cherry;
    }
}