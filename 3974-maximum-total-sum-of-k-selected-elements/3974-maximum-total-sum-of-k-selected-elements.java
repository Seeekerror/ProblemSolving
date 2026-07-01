class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long ans=0;
        int i=nums.length-1;
        while(mul > 0 && k > 0){
            ans += 1L * nums[i]*mul;
            i--;
            mul--;
            k--;
        }
        while(k > 0){
            ans += nums[i];
            i--;
            k--;
        }
        return ans;
    }
}