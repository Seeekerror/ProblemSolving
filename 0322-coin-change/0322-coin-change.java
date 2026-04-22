class Solution {
    int n;
    int [][] dp;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        dp = new int[n+1][amount+1];
        for(int [] row : dp) Arrays.fill(row,-1);
        int ans = solve(coins,amount,0);
        if(ans != Integer.MAX_VALUE) return ans;
        return -1;
    }
    int solve(int [] coins, int am, int i){
        if(i >= n) return Integer.MAX_VALUE;
        if(am == 0) return 0;
        if(dp[i][am] != -1) return dp[i][am];
        int skip = solve(coins,am,i+1);
        int pick=Integer.MAX_VALUE;
        if(coins[i] <= am){
            int ans = solve(coins,am-coins[i],i);
            if(ans != Integer.MAX_VALUE) pick = 1 + ans;
        }
        return dp[i][am] = Math.min(skip,pick);
    }
}