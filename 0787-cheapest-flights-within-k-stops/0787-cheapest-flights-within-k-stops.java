class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int [] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i = 0; i < k+1; i++){
            int[] prev = dist.clone();
            for(int [] f : flights){
                int u = f[0];
                int v = f[1];
                int wt = f[2];
                if(prev[u] != Integer.MAX_VALUE && prev[u] + wt < dist[v]){
                    dist[v] = prev[u] + wt;
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}