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
        if(i > j) return 0;
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = 2 + solve(s,i+1,j-1);
        }else{
            dp[i][j] = Math.max(solve(s,i+1,j), solve(s,i,j-1));
        }
        return dp[i][j];
    }
}