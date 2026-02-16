class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int longest = 0;
        int countOne = 0;
        int max = 0;
        for(int i = 0, j = 0; i < n; i++){
            if(nums[i] == 1) countOne++;

            max = Math.max(max,countOne);

            while((i-j+1) - max > 1){
                if(nums[j] == 1) countOne--;
                j++;
            }

            longest = Math.max(longest,i-j);

        }
        return longest;
    }
}