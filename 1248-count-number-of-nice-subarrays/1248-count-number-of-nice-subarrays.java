class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }
    int atmost(int [] nums , int k){
        int odd = 0;
        int j=0;
        int ct=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] % 2 != 0) odd++;
            while(odd > k){
                if(nums[j]%2!=0) odd--;
                j++;
            }
            ct += i-j+1;
        }
        return ct;
    }
}