class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    dp[i][j][k] = -1;

        int ans = solve(grid, 0, 0, n - 1, dp);
        return ans < 0 ? 0 : ans;

    }

    int solve(int[][] grid, int row, int c1, int c2, int[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;
        if (c1 < 0 || c1 >= n || c2 < 0 || c2 >= n)
            return Integer.MIN_VALUE;
        if (row == m - 1) {
            if (c1 == c2)
                return grid[row][c1];
            else
                return grid[row][c1] + grid[row][c2];
        }

        if (dp[row][c1][c2] != -1)
            return dp[row][c1][c2];

        int cherry;
        if (c1 == c2) {
            cherry = grid[row][c1];
        } else {
            cherry = grid[row][c1] + grid[row][c2];
        }

        int max = Integer.MIN_VALUE;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int next = solve(grid, row + 1, c1 + d1, c2 + d2, dp);
                max = Math.max(max, next);
            }
        }
        return dp[row][c1][c2] = max + cherry;
    }
}