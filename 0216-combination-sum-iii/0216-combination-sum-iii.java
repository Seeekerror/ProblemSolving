class Solution {
    List<List<Integer>> l;

    public List<List<Integer>> combinationSum3(int k, int n) {
        l = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        backtrack(k, n, ls, 1);
        return l;
    }

    void backtrack(int k, int n, List<Integer> ls, int i) {
        if (i > 9) {
            if (ls.size() == k) {
                if (n == 0) {
                    l.add(new ArrayList<>(ls));
                }
            }
            return;
        }
        ls.add(i);
        backtrack(k, n - i, ls, i + 1);
        ls.remove(ls.size() - 1);
        backtrack(k, n, ls, i + 1);
    }
}