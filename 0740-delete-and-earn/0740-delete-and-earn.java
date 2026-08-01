class Solution {
    int [] dp;
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }
        int max=0;
        for(int num : nums){
            max = Math.max(max,num);
        }
        int [] arr = new int[max+1];
        for(int key : map.keySet()){
            int val = map.get(key);
            arr[key] = key * val;
        }
        dp = new int[max+1];
        Arrays.fill(dp,-1);
        return solve(arr,max);
    }
    int solve(int [] arr , int i){
        if(i == 0) return arr[i];
        if(i < 0) return 0;
        if(dp[i] != -1) return dp[i];
        int pick = arr[i] + solve(arr,i-2);
        int skip = solve(arr,i-1);
        return dp[i] = Math.max(pick,skip);
    }
}