class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=i+1;j<n;j++){
                if(nums[i]%2!=0){
                    if(nums[j]%2==0) count++;
                }else{
                    if(nums[j]%2!=0)count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}