class Solution {
    public long maxPairStrength(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long g = gcd(nums[i], nums[j]);
                long ans = (1L * nums[i] * nums[j]) / (g * g);
                res = Math.max(res, ans);
            }
        }
        return res;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}