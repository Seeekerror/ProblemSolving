class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int s = 0;
        for(int x : nums){
            s+=x;
        }
        if (s % 2 != 0) return false;
        int [][] dp = new int[n+1][s/2+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= s/2; j++){
                if(nums[i] <= j){
                    dp[i+1][j] = Math.max(dp[i][j] , nums[i]+dp[i][j-nums[i]]);
                }else{
                    dp[i+1][j] = dp[i][j];
                }
            }
        }
        return dp[n][s/2] == s/2;
    }
}