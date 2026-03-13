class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> a[0] - b[0]);
        int [][] dp = new int[pairs.length][pairs.length];
        for(int [] row : dp) Arrays.fill(row,-1);
        return solve(pairs,0,-1,dp);
    }
    int solve(int [][] pairs, int i, int prev,int [][] dp){
        if(i == pairs.length) return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int skip = solve(pairs,i+1,prev,dp);
        int pick = 0;
        if(prev == -1 || pairs[prev][1] < pairs[i][0]){
            pick = 1 + solve(pairs,i+1,i,dp);
        }

        return dp[i][prev+1] = Math.max(skip,pick);
    }
}