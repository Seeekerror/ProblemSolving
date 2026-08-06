class Solution {
    int [][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int [] row : dp) Arrays.fill(row,-1);
        return solve(nums,0,-1);
    }
    int solve(int [] arr , int i ,int j){
        if(i >= arr.length) return 0;
        if(dp[i][j+1] != -1) return dp[i][j+1];
        int skip = solve(arr,i+1,j);
        int pick = 0;
        if(j == -1 || arr[i] > arr[j]){
            pick = 1 + solve(arr,i+1,i);
        }
        return dp[i][j+1] = Math.max(skip,pick);
    }
}