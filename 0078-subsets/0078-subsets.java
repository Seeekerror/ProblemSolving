class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        subset(nums, l, ls, 0);
        return l;
    }

    public void subset(int [] nums, List<List<Integer>> l, List<Integer> ls, int i) {
        if (i == nums.length) {
            l.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[i]);
        subset(nums, l, ls, i + 1);
        ls.remove(ls.size() - 1);
        subset(nums, l, ls, i + 1);
    }

}