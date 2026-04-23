class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = n - 1;
            int j = i + 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (j < k) {
                int num = nums[i] + nums[j] + nums[k];
                if (num == 0) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    l.add(ls);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1])j++;
                    while(j < k && nums[k] == nums[k+1])k--;
                } else if (num > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return l;
    }
}