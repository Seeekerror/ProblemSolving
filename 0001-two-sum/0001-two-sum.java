class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        
        for(int key : map.keySet()){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] + key == target) return new int[]{i,map.get(key)};
            }
        }
        return new int[]{-1,-1};
    }
} 