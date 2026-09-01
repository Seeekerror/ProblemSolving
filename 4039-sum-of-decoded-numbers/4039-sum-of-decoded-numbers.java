class Solution {

    public int sumDecoded(long[] nums) {

        long ans = 0;
        int x = 0;
        long mod = 1000000007L;

        while (x < nums.length) {

            int wid = (int)(nums[x] % 10);

            long di = nums[x] / 10;

            String st = Long.toString(di);

            long xi = Long.parseLong(st.substring(0, wid));
            long yi = Long.parseLong(st.substring(wid));

            ans = (ans + power(xi, yi, mod)) % mod;

            x++;
        }

        return (int)ans;
    }

    long power(long x, long y, long mod) {

        long ans = 1;

        while (y > 0) {

            if (y % 2 == 1) {
                ans = (ans * x) % mod;
            }

            x = (x * x) % mod;
            y /= 2;
        }

        return ans;
    }
}