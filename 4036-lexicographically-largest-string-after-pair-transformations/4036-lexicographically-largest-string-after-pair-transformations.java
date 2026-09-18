class Solution {

    public String[] largestString(int[] nums) {

        String[] ar = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            StringBuilder sb = new StringBuilder();

            // handle z
            int z = num / (1 << 25);
            num %= (1 << 25);

            int j = 0;

            while (num > 0) {

                int rem = num % 2;

                if (rem == 1) {
                    sb.append((char)('a' + j));
                }

                j++;
                num /= 2;
            }

            sb.reverse();

            // put z's in front
            for (int k = 0; k < z; k++) {
                sb.insert(0, 'z');
            }

            ar[i] = sb.toString();
        }

        return ar;
    }
}