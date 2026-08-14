class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums,goal)-atMost(nums,goal-1);
    }
    int atMost(int[] nums, int goal){
        if (goal < 0) return 0;
        int l = 0, r = 0;
        int ans = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}