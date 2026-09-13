class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[0].length; j++) {
                for (int k = 0; k < img2.length; k++) {
                    for (int l = 0; l < img2[0].length; l++) {
                        if (img1[i][j] == 1 && img2[k][l] == 1) {
                            int r = i - k;
                            int c = j - l;
                            String key = r + "," + c;
                            map.put(key, map.getOrDefault(key, 0) + 1);
                            res = Math.max(res, map.get(key));
                        }
                    }
                }
            }
        }
        return res;
    }
}