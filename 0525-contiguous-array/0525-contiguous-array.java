class Solution {
    public int findMaxLength(int[] nums) {
        int one = 0;
        int zero = 0;
        int r = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        while (r < nums.length) {
            if (nums[r] == 1) {
                one++;
            } else {
                zero++;
            }
            int dif = one - zero;
            if (map.containsKey(dif)) {
                len = Math.max(len, r - map.get(dif));
            } else {
                map.put(dif, r);
            }
            r++;
        }
        return len;
    }
}