class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd = 0;
        int even = 0;
        int ans = 0;
        int sum = 0;
        int mod = 1000000007;
        for(int x : arr){
            sum += x;
            if(sum % 2 == 0){
                ans = (ans + odd)%mod;
                even++;
            }else{
                ans = (ans + even+1)%mod;
                odd++;
            }
        }
        return ans;
    }
}