class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int sum=0;
        for(int x : weights){
            sum += x;
            max = Math.max(x,max);
        }
        int st = max;
        int ed = sum;
        int ans=-1;
        while(st <= ed){
            int mid = st + (ed-st)/2;
            if(isPossible(weights,days,mid)){
                ans = mid;
                ed = mid-1;
            }else{
                st = mid+1;
            }
        }
        return ans;
    }
    boolean isPossible(int [] arr, int days, int mid){
        int sum = 0;
        int day = 1;
        for(int x : arr){
            if(sum + x <= mid){
                sum += x;
            }else{
                day++;
                sum = x;
            }
        }
        return day <= days;
    }
}