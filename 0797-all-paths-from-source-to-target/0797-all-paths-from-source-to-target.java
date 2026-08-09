class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        dfs(graph, 0, adj, l,graph.length-1);
        return adj;

    }

    void dfs(int[][] graph, int st, List<List<Integer>> adj, List<Integer> l, int des) {
        l.add(st);
        if (st == des) {
            adj.add(new ArrayList<>(l));
        } else {
            for (int g : graph[st]) {
                dfs(graph, g, adj, l,des);
            }
        }
        l.remove(l.size() - 1);
    }
}