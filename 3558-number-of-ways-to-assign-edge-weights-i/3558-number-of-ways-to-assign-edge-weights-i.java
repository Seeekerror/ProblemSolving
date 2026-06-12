class Solution {
    Long[][] dp;
    int p = 1000000007;

    public int assignEdgeWeights(int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length + 1;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n + 1];
        int maxLen = dfs(adj, 1, visited);
        // dp = new Long[maxLen + 1][maxLen * 2];
        // return (int) (rec(maxLen, 0) % p);
        return pow(2, maxLen - 1);
    }

    int pow(long base, long exp) {
        long res = 1;

        while (exp > 0) {
            res = (res * base) % p;
            exp--;
        }
        return (int) res;
    }

    long rec(int k, int n) {
        if (k == 0) {
            if (n % 2 != 0)
                return 1;
            return 0;
        }
        if (dp[k][n] != null)
            return dp[k][n];
        return dp[k][n] = rec(k - 1, n + 1) + rec(k - 1, n + 2);
    }

    int dfs(List<List<Integer>> adj, int node, boolean[] visited) {

        int max = 0;
        visited[node] = true;
        for (int nodes : adj.get(node)) {
            if (!visited[nodes]) {
                max = Math.max(max, 1 + dfs(adj, nodes, visited));
            }
        }
        return max;
    }
}