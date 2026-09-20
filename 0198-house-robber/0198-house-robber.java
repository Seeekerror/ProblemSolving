class Solution {
    int [] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return Math.max(solve(nums,0) , solve(nums,1));
    }
    int solve(int [] nums , int i){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        int pick = nums[i] + solve(nums,i+2);
        int skip = solve(nums,i+1);
        return dp[i] = Math.max(pick,skip);
    }
}