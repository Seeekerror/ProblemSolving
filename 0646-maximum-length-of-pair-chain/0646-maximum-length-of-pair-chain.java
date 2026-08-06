class Solution {
    int [][] dp;
    public int findLongestChain(int[][] pairs) {
        dp = new int[pairs.length][pairs.length];
        for(int [] row : dp) Arrays.fill(row,-1);
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        return solve(pairs,0,-1);
    }
    int solve(int [][] pairs , int i , int j){
        if(i >= pairs.length) return 0;
        if(dp[i][j+1] != -1) return dp[i][j+1];
        int skip = solve(pairs,i+1,j);
        int pick=0;
        if(j == -1 || pairs[i][0] > pairs[j][1]){
            pick = 1 + solve(pairs,i+1,i);
        }
        return dp[i][j+1] = Math.max(skip,pick);
    }
}