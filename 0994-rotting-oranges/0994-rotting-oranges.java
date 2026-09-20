class Solution {
    public int orangesRotting(int[][] grid) {
        int org = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    org++;
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        if (org == 0) return 0;
        int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] x = q.poll();
                int u = x[0];
                int v = x[1];
                for (int i = 0; i < 4; i++) {
                    int nu = u + pos[i][0];
                    int nv = v + pos[i][1];
                    if (nu >= 0 && nu < grid.length && nv >= 0 && nv < grid[0].length && grid[nu][nv] == 1) {
                        grid[nu][nv] = 2;
                        q.add(new int[] { nu, nv });
                        org--;
                    }
                }
            }
            ans++;
        }
        if (org == 0)
            return ans-1;
        return -1;
    }
}