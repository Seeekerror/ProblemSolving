class Solution {
    // class Node {
    // int w;
    // int x;
    // int y;

    //     Node(int w, int x, int y) {
    //         this.w = w;
    //         this.x = x;
    //         this.y = y;
    //     }
    // }

    public int minimumEffortPath(int[][] heights) {

        if(heights.length == 1 && heights[0].length == 1) return 0;
        return dijkstra(heights);
    }

    int dijkstra(int[][] heights) {
        int [][] result = new int[heights.length][heights[0].length];
        for (int[] row : result)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0,0,0});

        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,-1,1};
        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            int wt = cur[0];
            int ix = cur[1];
            int jy = cur[2];

            for(int i = 0; i < 4; i++){
                int nx = ix + dx[i];
                int ny = jy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < heights.length && ny < heights[0].length){
                    int absval = Math.abs(heights[ix][jy] - heights[nx][ny]);
                    absval = Math.max(absval,wt);
                    if(absval < result[nx][ny]){
                        result[nx][ny] = absval;
                        pq.add(new int[]{result[nx][ny],nx,ny});
                    }
                }

            }

        }
        return result[heights.length-1][heights[0].length-1];
    }
}