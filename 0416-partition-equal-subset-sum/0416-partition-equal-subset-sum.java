class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        int s = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][s + 1];
        return part(nums, s, 0, dp);
    }

    boolean part(int[] nums, int sum, int i, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (i == nums.length)
            return false;
        if (dp[i][sum] != null)
            return dp[i][sum];
        Boolean take = false;
        if (nums[i] <= sum) {
            take = part(nums, sum - nums[i], i + 1, dp);
        }
        boolean skip = part(nums, sum, i + 1, dp);
        return dp[i][sum] = take || skip;
    }
}
