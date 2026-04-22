class Solution {
    int n;
    int [][] dp;
    public int longestPalindromeSubseq(String s) {
        n = s.length();
        dp = new int[n][n];
        for(int [] row : dp) Arrays.fill(row,-1);
        return solve(s,0,n-1);
    }
    int solve(String s, int i, int j){
        if(i >= n || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int skip = Math.max(solve(s,i+1,j),solve(s,i,j-1));
        int pick=0;
        if(s.charAt(i) == s.charAt(j)){
            pick = 1 + solve(s,i+1,j-1);
        }
        return dp[i][j] = Math.max(skip,pick);
    }
}