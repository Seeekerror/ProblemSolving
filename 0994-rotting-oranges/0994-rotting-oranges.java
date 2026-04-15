class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        int minutes = 0;
        if(fresh == 0) return 0;
        while(!q.isEmpty()&& fresh > 0){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int [] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int [][] arr = {{-1,0},{1,0},{0,-1},{0,1}};
                for(int [] nie : arr){
                    int nr = r + nie[0];
                    int nc = c + nie[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int [] {nr,nc});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0?minutes:-1;
    }
} 