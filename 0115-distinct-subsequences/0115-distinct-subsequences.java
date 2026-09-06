class Solution {
    public int numDistinct(String s, String t) {
        int [][] dp = new int[s.length()+1][t.length()+1];
        // for(int [] row : dp){
        //     Arrays.fill(row,-1);
        // }
        //j is col and i is row
        dp[0][0] = 1;
        for(int j = 1; j <= t.length(); j++){
            dp[0][j]  = 0;
        }
        for(int i = 1; i <= s.length(); i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
        //return num(s,t,0,0,dp);
    }
    int num(String s, String t,int i, int j,int[][]dp){
        if(j == t.length())return 1;
        if(i == s.length() && j < t.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int pick = 0;
        int skip = 0;
        
        if(s.charAt(i)==t.charAt(j)){
            pick = num(s,t,i+1,j+1,dp)+num(s,t,i+1,j,dp);
        }else{
            skip = num(s,t,i+1,j,dp);
        }
        return dp[i][j] = pick+skip;
    }
}