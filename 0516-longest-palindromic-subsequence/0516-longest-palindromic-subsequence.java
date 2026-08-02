class Solution {
    int [][] dp;
    public int longestPalindromeSubseq(String s) {
        dp = new int[s.length()][s.length()];
        for(int [] row : dp) Arrays.fill(row,-1);
        return solve(s,0,s.length()-1);
    }
    int solve(String s , int i , int j){
        if(i >= s.length() || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int pick = 0;
        if(s.charAt(i) == s.charAt(j)){
            pick = 1 + solve(s,i+1,j-1);
        }
        int skip = Math.max(solve(s,i,j-1) , solve(s,i+1,j));
        return dp[i][j] = Math.max(pick,skip);
    }
}