class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                min = Math.min(min,i-j+1);
                sum -= nums[j++];
            }
        }
        return min == Integer.MAX_VALUE?0 : min;
    }
}