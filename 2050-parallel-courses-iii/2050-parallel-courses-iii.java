class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e : relations){
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
        }
        int [] in = new int[n+1];
        for(int i = 1; i <= n; i++){
            for(int nei : adj.get(i)){
                in[nei]++;
            }
        }
        int [] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            dp[i] = time[i-1];
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(in[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : adj.get(node)){
                dp[nei] = Math.max(dp[nei] , dp[node] + time[nei-1]);
                in[nei]--;
                if(in[nei] == 0){
                    q.add(nei);
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}