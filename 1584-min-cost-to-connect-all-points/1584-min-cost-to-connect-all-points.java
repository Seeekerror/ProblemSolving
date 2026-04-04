class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>(); 
        for(int i = 0; i < points.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                int val = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{j,val});
                adj.get(j).add(new int[]{i,val});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0,0});
        boolean [] vis = new boolean[points.length];
        int sum = 0;
        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            int u = cur[0];
            int wt = cur[1];
            if(vis[u]) continue;
            vis[u] = true;
            sum += wt;
            for(int [] nei : adj.get(u)){
                int node = nei[0];
                int w = nei[1];
                if(!vis[node]){
                    pq.add(new int[]{node,w});
                }
            }
        }
        return sum;
    }
}