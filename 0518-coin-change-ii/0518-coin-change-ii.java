class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length][amount+1];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        return chnge(amount, coins, coins.length - 1,dp);
    }

    int chnge(int amount, int[] coins, int i,int [][] dp) {
        if(amount == 0) return 1;
        if (i < 0) {
            return 0;
        }
        
        if(dp[i][amount] != -1) return dp[i][amount];
        int skip = chnge(amount, coins, i - 1,dp);
        int pick = 0;
        if (coins[i] <= amount) {
            pick = chnge(amount - coins[i], coins, i,dp);
        }
        return dp[i][amount] = skip + pick;
    }
}