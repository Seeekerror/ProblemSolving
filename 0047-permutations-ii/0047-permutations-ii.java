class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        back(nums,0,set);
        List<List<Integer>> l = new ArrayList<>(set);
        return l;
    }

    void back(int [] nums, int st, Set<List<Integer>> set){
        if(st >= nums.length){
            List<Integer> ls = new ArrayList<>();
            for(int num : nums){
                ls.add(num);
            }
            set.add(new ArrayList<>(ls));
            return;
        }

        for(int i = st; i < nums.length; i++){
            swap(nums,i,st);
            back(nums,st+1,set);
            swap(nums,i,st);
        }

    }
    void swap(int [] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}