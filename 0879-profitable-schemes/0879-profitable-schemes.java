class Solution {
    int [][][] dp;
    int mod = 1_000_000_007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        dp = new int[m][n+1][minProfit+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(n,minProfit,group,profit,0,0,0);
    }

    int solve(int n, int min, int [] group, int [] profit, int sum, int i, int mem){
        int m = group.length;
        sum = Math.min(sum, min);
        if(i == m){
            return sum >= min ? 1 : 0;
        }
        if(dp[i][mem][sum] != -1) return dp[i][mem][sum];
        int pick = 0;
        if(mem+group[i] <= n){
            pick = solve(n,min,group,profit,sum+profit[i],i+1,mem+group[i]);
        }
        int skip = solve(n,min,group,profit,sum,i+1,mem);
        return dp[i][mem][sum] =( pick + skip) % mod;
    }
}