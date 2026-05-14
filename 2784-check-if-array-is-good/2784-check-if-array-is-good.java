class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum=0;
        if(nums[0] != 1) return false;
        if(n == 1) return false;
        if(nums[n-1] > n) return false;
        for(int i=1;i<n-1;i++){
            if(nums[i-1] == nums[i]){
                return false;
            }
        }
        if(nums[n-2] == nums[n-1]){
            return true;
        }
        return false;
    }
}