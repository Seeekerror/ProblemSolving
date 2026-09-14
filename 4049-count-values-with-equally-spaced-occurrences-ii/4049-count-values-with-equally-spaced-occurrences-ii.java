class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(i);
        }
        int c = 0;
        for (int key : map.keySet()) {
            List<Integer> l = new ArrayList<>(map.get(key));
            boolean valid = true;
            if (l.size() >= 3) {
                for (int i = 1; i < l.size() - 1; i++) {
                    if (l.get(i) - l.get(i - 1) != l.get(i + 1) - l.get(i)) {
                        valid = false;
                    }
                }
            }
            if (l.size() >= 3 && valid) {
                c++;
            }
        }
        return c;
    }
}