class Solution {
    public long maxRatings(int[][] units) {
        for (int[] u : units) {
            Arrays.sort(u);
        }
        long totalsum = 0;
        int secondmin = Integer.MAX_VALUE;
        int globalmin = Integer.MAX_VALUE;
        for (int i = 0; i < units.length; i++) {
            if (units[i].length == 1) {
                totalsum += units[i][0];
            } else {
                totalsum += units[i][1];
                secondmin = Math.min(secondmin, units[i][1]);
                globalmin = Math.min(globalmin, units[i][0]);
            }
        }
        if (secondmin != Integer.MAX_VALUE) {
            return totalsum - secondmin + globalmin;
        }
        return totalsum;
    }
}