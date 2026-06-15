class Solution {
    int [] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0);
    }
    int solve(int [] nums,int i){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        int skip = solve(nums,i+1);
        int pick = nums[i] + solve(nums,i+2);
        return dp[i] = Math.max(skip,pick);
    }
}