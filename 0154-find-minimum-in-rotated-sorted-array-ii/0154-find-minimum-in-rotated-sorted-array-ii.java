class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int x : nums){
            min = Math.min(min,x);
        }
        return min;
    }
}