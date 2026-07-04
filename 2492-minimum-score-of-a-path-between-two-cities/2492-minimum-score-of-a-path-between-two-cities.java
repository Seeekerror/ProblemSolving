class Solution {
        List<List<int[]>> l;
        int ans = Integer.MAX_VALUE;
        boolean [] vis;
    public int minScore(int n, int[][] roads) {
        vis = new boolean[n+1];
        l = new ArrayList<>();
        for(int i=0;i<=n;i++){
            l.add(new ArrayList<>());
        }
        for(int [] x : roads){
            int u=x[0];
            int v=x[1];
            int w=x[2];
            l.get(u).add(new int []{v,w});
            l.get(v).add(new int []{u,w});
        }
        dfs(1);
        return ans;
    }
    void dfs(int src){
        vis[src] = true;
        for(int [] nei : l.get(src)){
            int u = nei[0];
            int wt = nei[1];
            ans = Math.min(ans, wt);
            if(!vis[u]){
                dfs(u);
            }
        }
    }
}