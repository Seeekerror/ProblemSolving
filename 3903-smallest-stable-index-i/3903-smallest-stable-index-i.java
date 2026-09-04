class Solution {
    public int firstStableIndex(int[] nums, int k) {
        if(nums.length == 1) return 0;
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            int min = Integer.MAX_VALUE;
            max = Math.max(nums[i],max);
            for(int j=i;j<nums.length;j++){
                min = Math.min(min,nums[j]);
            }
            if(max - min <= k) return i;
        }
        return -1;
    }
}