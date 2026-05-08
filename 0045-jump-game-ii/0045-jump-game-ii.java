class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return solve(nums, nums.length, 0, dp);
    }

    int solve(int[] nums, int n, int i, int dp[]) {
        if (i >= n - 1)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= nums[i]; x++) {
            int res = solve(nums, n, i + x, dp);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }
        dp[i] = min;
        return dp[i];
    }
}