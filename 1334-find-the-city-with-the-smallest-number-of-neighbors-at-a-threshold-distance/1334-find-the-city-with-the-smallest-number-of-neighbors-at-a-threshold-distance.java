class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] hlp = new int[n];
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            int count = 0;
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            for (int j = 0; j < n - 1; j++) {
                for (int[] e : edges) {
                    int u = e[0];
                    int v = e[1];
                    int wt = e[2];
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                    if (dist[v] != Integer.MAX_VALUE && dist[v] + wt < dist[u]) {
                        dist[u] = dist[v] + wt;
                    }
                }
            }
            for (int k = 0; k < n; k++) {
                if (dist[k] <= distanceThreshold) {
                    count++;
                }
            }
            hlp[i] = count;
        }
        int hlps = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            System.out.print(hlp[i] + " ");
            hlps = Math.min(hlp[i], hlps);
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (hlp[i] == hlps) {
                //System.out.print(i);
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }
}
