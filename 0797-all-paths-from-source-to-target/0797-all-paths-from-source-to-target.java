class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        //boolean[] vis = new boolean[graph.length];
        dfs(graph, ans, l, 0, graph.length - 1);
        return ans;
    }

    void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> l, int node, int tar) {

        l.add(node);
        if (node == tar) {
            ans.add(new ArrayList<>(l));
        } else {
            for (int g : graph[node]) {
                dfs(graph, ans, l, g, tar);

            }
        }
        l.remove(l.size() - 1);
    }
}