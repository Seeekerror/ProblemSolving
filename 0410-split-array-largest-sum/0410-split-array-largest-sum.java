class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        for(int x : nums){
            left = Math.max(x,left);
        }   
        int right = 0;
        for(int x : nums){
            right += x;
        }
        while(left <= right){
            int mid = left + (right - left)/2;

            int subs = cal(nums,mid);

            if(subs <= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    int cal(int [] nums, int limit){
        int subs = 1;
        int sum = 0;
        for(int x : nums){
            if(sum + x > limit){
                subs++;
                sum = x;
            }else{
                sum += x;
            }
        }
        return subs;
    }
}