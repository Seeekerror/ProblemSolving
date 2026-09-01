class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            if(set.contains(nums[i])){
                hs.add(nums[i]);
            }
            set.add(nums[i]);
        }
        return set.size()-hs.size();
    }
}