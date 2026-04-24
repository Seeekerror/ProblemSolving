class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];

            adj.get(u).add(new double[]{v, w});
            adj.get(v).add(new double[]{u, w});
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.add(new double[]{start_node,1.0});
        double [] dis = new double[n];
        Arrays.fill(dis,0.0);
        dis[start_node] = 1.0;
        while(!pq.isEmpty()){
            double [] cur = pq.poll();
            int u = (int)cur[0];
            double w = cur[1];
            if (u == end_node) return w;
            //if (w < dis[u]) continue;
            for(double [] nei : adj.get(u)){
                int v = (int)nei[0];
                double nd = w*nei[1];
                if(nd < dis[v]) continue;
                if(nd > dis[v]){
                    dis[v] = nd;
                    pq.add(new double[]{v,nd});
                }
            }
        }
        return 0.0;
        //return dis[end_node];
    }
}