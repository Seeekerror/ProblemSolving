class Solution {
    int n;
    HashMap<String,Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        map = new HashMap<>();
        return solve(nums,target,0);
    }
    int solve(int[] nums, int tar,int i){
        if(i >= n){
            if(tar == 0) return 1;
            return 0;
        }
        String key = i+"."+tar;
        if(map.containsKey(key)) return map.get(key);
        int count = 0;
        count += solve(nums,tar+nums[i],i+1);
        count += solve(nums,tar-nums[i],i+1);
        map.put(key,count);
        return count;
    }
}