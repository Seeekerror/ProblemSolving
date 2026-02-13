class Solution {
    public int shortestBridge(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int flag = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    dfs(grid, vis, i, j);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                break;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    q.add(new int[] { i, j });
                    vis[i][j] = true;
                }
            }
        }
        return bfs(grid, vis, q);
    }

    int bfs(int[][] grid, boolean[][] vis, Queue<int[]> q) {

        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            int[][] arr = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
            for (int j = 0; j < size; j++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for (int i = 0; i < 4; i++) {
                    int[] ar = arr[i];
                    int nx = x + ar[0];
                    int ny = y + ar[1];

                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length)
                        continue;

                    if (grid[nx][ny] == -1)
                        return count;

                    if (grid[nx][ny] == 0) {
                        grid[nx][ny] = 1;
                        q.add(new int[] { nx, ny });
                        vis[nx][ny] = true;
                    }
                }
            }
            count++;

        }
        return count;

    }

    void dfs(int[][] grid, boolean[][] vis, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || vis[r][c] || grid[r][c] == 0) {
            return;
        }

        vis[r][c] = true;
        grid[r][c] = -1;

        dfs(grid, vis, r + 1, c);
        dfs(grid, vis, r - 1, c);
        dfs(grid, vis, r, c + 1);
        dfs(grid, vis, r, c - 1);

    }
}
