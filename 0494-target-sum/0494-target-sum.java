class Solution {
    int n;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        return solve(nums,target,0);
    }
    int solve(int[] nums, int tar,int i){
        if(i >= n){
            if(tar == 0) return 1;
            return 0;
        }
        int count = 0;
        count += solve(nums,tar+nums[i],i+1);
        count += solve(nums,tar-nums[i],i+1);
        return count;
    }
}