class Solution {
    List<List<Integer>> dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> ls = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                ls.add(Integer.MIN_VALUE);
            }
            dp.add(ls);
        }
        return solve(triangle, 0, 0);
    }

    int solve(List<List<Integer>> tri, int i, int j) {
        if (i >= tri.size() || j >= tri.get(i).size())
            return Integer.MAX_VALUE;
        if (i == tri.size() - 1)
            return tri.get(i).get(j);
        if (dp.get(i).get(j) != Integer.MIN_VALUE)
            return dp.get(i).get(j);
        int f = solve(tri, i + 1, j);
        int s = solve(tri, i + 1, j + 1);
        int ans = tri.get(i).get(j) + Math.min(f, s);
        dp.get(i).set(j, ans);
        return dp.get(i).get(j);
    }
}