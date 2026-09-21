class Solution {
    int [][][] dp;
    int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove+1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return (int)solve(m, n, startRow, startColumn, maxMove)%MOD;
    }

    int solve(int m, int n, int i, int j, int max) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 1;
        if (max == 0)
            return 0;
        if(dp[i][j][max] != -1) return dp[i][j][max];
        int left = solve(m, n, i - 1, j, max - 1);
        int right = solve(m, n, i + 1, j, max - 1);
        int up = solve(m, n, i, j - 1, max - 1);
        int down = solve(m, n, i, j + 1, max - 1);
        return dp[i][j][max] = (int)(((long)left + right + up + down) % MOD);
    }
}