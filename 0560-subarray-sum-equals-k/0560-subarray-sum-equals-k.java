class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int r=0;
        int ans=0;
        int sum =0;
        while(r < nums.length){
            sum += nums[r];
            if(map.containsKey(sum - k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            r++;
        }
        return ans;
    }
}