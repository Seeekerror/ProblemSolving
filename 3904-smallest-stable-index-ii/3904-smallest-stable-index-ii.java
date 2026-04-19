class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int [] pref = new int[nums.length];
        int [] suff = new int[nums.length];
        pref[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            pref[i] = Math.max(nums[i] , pref[i-1]);
        }
        suff[nums.length-1] = nums[nums.length-1]; 
        for(int i = nums.length-2; i >= 0; i--){
            suff[i] = Math.min(suff[i+1] , nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            if(pref[i] - suff[i] <= k){
                return i;
            }

        }
        return -1;
    }
}