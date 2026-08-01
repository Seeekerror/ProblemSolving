class Solution {
    int [][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for(int [] row : dp) Arrays.fill(row,-1);
        return solve(m-1,n-1);
    }
    int solve(int m , int n){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = solve(m-1,n) + solve(m,n-1);
    }
}