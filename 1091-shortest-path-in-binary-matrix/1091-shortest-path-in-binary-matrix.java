class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1) return -1;
        boolean [][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        vis[0][0] = true;
        int dist = 1;
        while (!q.isEmpty()) {
            int[][] dir = {
                    { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 },
                    { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }};
            int size = q.size();
            for(int i = 0; i < size; i++){
                int [] arr = q.poll();
                int r = arr[0];
                int c = arr[1];

                if(r == n-1 && c == n-1) return dist;
                for (int [] nd : dir) {
                    int nr = r + nd[0];
                    int nc = c + nd[1];

                    if(nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0 && !vis[nr][nc]){
                        vis[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            dist++;
        }
        return -1;

    }

}