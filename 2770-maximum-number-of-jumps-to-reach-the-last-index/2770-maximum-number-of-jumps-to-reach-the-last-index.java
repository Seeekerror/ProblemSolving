class Solution {
    int[] dp;
    int n;
    public int maximumJumps(int[] nums, int target) {
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -10);
        return solve(nums,target,0);
    }
    int solve(int [] nums, int target, int i){
        if(i == n-1) return 0;
        if(dp[i] != -10) return dp[i];
        int res = Integer.MIN_VALUE;
        for(int j=i+1;j<n;j++){
            int num = nums[j]-nums[i];
            if(num >= (-target) && num <= target){
                int ans = solve(nums,target,j);
                if(ans != -1){
                    res = Math.max(res,ans+1);
                }
            }
        }
        return dp[i] = (res == Integer.MIN_VALUE ? -1 : res);
    }
}