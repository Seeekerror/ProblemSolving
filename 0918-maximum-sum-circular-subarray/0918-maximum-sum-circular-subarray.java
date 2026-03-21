class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int curmax = 0;
        int curmin = 0;

        int total = 0;
        for(int num : nums){
            curmax = Math.max(curmax+num,num);
            if(curmax > max) max = curmax;
            
            curmin = Math.min(curmin+num,num);
            min = Math.min(curmin,min);

            total += num;
        }

        if(max < 0) return max;
        return Math.max(max,total-min);
    }
}