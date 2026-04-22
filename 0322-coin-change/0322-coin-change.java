class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        
        int [][] dp = new int[coins.length][amount+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int ans = coin(coins,amount,coins.length-1,dp);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
    int coin(int[] coins, int amount,int i,int [][] dp){
        if(i < 0) return Integer.MAX_VALUE;
        if(amount == 0) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int skip = coin(coins,amount,i-1,dp);
        int pick = Integer.MAX_VALUE;
        if(coins[i] <= amount){
            int ans = coin(coins,amount-coins[i],i,dp);
            if(ans != Integer.MAX_VALUE) pick = 1 + ans;
        }
        return dp[i][amount] = Math.min(skip,pick);
    }
}
