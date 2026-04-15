class Solution {
    public int majorityElement(int[] nums) {
        // int c = 0;
        // int ct = 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if(set.contains(x)) continue;
            int c = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[i] == nums[j]) c++;
                if(c > (n/2)) return nums[j];
            }
            set.add(x);
        }
        return -1;
    }
}