class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int can = 0;
        for(int x : nums){
            if(count == 0) can = x;
            if(x == can){
                count++;
            }else{
                count--;
            }
        }
        return can;
    }
}