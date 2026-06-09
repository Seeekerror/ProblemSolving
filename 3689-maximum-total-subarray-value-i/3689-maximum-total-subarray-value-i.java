class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int x : nums){
            max = Math.max(x,max);
            min = Math.min(x,min);
        }
        long ans=0;
        for(int i=0;i<k;i++){
            ans += (max-min);
        }
        return ans;
    }
}