class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower = lowerbound(nums,target);
        int upper = upperbound(nums,target);
        if (lower == nums.length || nums[lower] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{lower,upper-1};
    }      
    int upperbound(int [] nums, int tar){
        int l = 0;
        int r = nums.length;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] > tar){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    int lowerbound(int [] nums, int tar){
        int l = 0;
        int r = nums.length;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] >= tar){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}