class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            adj.get(u).add(new int[] { v, w });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] dis = new int[n + 1];

        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[k] = 0;
        pq.add(new int[] { k, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int w = cur[1];

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int nd = dis[u] + edge[1];
                if (nd > dis[v])
                    continue;
                if (nd < dis[v]) {
                    dis[v] = nd;
                    pq.add(new int[] { v, nd });
                }
            }

        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dis[i]);
        }

        return ans;

    }
}