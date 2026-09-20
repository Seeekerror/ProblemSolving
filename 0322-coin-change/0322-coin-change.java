class Solution {
    int [][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        for(int [] row : dp) Arrays.fill(row,-1);
        int ans = solve(coins, amount, coins.length - 1);
        if (ans != Integer.MAX_VALUE)
            return ans;
        return -1;
    }

    int solve(int[] coins, int am, int i) {
        if (i < 0)
            return Integer.MAX_VALUE;
        if(am == 0) return 0;
        if(dp[i][am] != -1) return dp[i][am];
        int pick = Integer.MAX_VALUE;
        if (coins[i] <= am) {
            int res = solve(coins, am - coins[i], i);
            if (res != Integer.MAX_VALUE)
                pick = 1 + res;
        }
        int skip = solve(coins, am, i - 1);
        return dp[i][am] = Math.min(pick, skip);
    }
}