class Solution {
    int [][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for(int [] row : dp) Arrays.fill(row,-1);
        return solve(text1,text2,0,0);
    }
    int solve(String t1 , String t2 , int i , int j){
        if(i >= t1.length() || j >= t2.length())return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int skip = Math.max(solve(t1 , t2, i+1, j) , solve(t1 , t2, i, j+1));
        int pick = 0;
        if(t1.charAt(i) == t2.charAt(j)){
            pick = 1 + solve(t1,t2,i+1,j+1);
        }
        return dp[i][j] = Math.max(pick,skip);
    }
} 