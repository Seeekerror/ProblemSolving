class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int[] tail = new int[envelopes.length];
        int size = 0;
        for (int[] x : envelopes) {
            int l = 0, r = size;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (x[1] > tail[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            tail[l] = x[1];
            if (l == size)
                size++;
        }
        return size;
    }
}