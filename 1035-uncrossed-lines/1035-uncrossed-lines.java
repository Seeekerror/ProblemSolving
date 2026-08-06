class Solution {
    int [][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length];
        for(int [] row : dp) Arrays.fill(row,-1);
        return solve(nums1,nums2,0,0);
    }
    int solve(int [] ar , int [] arr , int i , int j){
        if(i >= ar.length || j >= arr.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int skip = Math.max(solve(ar,arr,i+1,j),solve(ar,arr,i,j+1));
        int pick = 0;
        if(ar[i] == arr[j]){
            pick = 1 + solve(ar, arr, i+1 , j+1);
        }
        return dp[i][j] = Math.max(skip,pick);
    }
}