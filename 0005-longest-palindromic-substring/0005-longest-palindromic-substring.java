class Solution {
    int max = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        int st = 0, ed = 0;
        boolean dp[][] = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i - j <= 2 || dp[j+1][i-1]){
                        dp[j][i] = true;
                        if(max < i - j + 1){
                            max = i - j + 1;
                            st = j;
                            ed = i;
                        }
                    }
                }
            }
        }
        return s.substring(st,ed+1);
    }
}