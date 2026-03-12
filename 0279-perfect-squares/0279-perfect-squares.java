class Solution {
    public int numSquares(int n) {
        int max = (int)Math.sqrt(n);
        int [][] dp = new int[max+1][n+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return sq(n, 1,dp);
    }

    int sq(int n, int i,int [][] dp) {
        if(n == 0) return 0;

        if(i*i > n) return Integer.MAX_VALUE;
        
        if(dp[i][n] != -1) return dp[i][n];
        int skip = sq(n,i+1,dp);
        int pick = Integer.MAX_VALUE;
        if(i*i <= n){
            int ans = sq(n - i*i,i,dp);
            if(ans != Integer.MAX_VALUE) pick =1+ ans;
        }

        return dp[i][n] = Math.min(skip , pick);
    }
}