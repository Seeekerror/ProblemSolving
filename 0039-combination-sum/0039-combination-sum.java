class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        //Arrays.sort(candidates);
        sum(l, ls, candidates, 0, target);
        return l;
    }
    void sum(List<List<Integer>> l, List<Integer> ls, int[] candidates, int i, int target) {
        int n = candidates.length;
        if (target == 0) {
            l.add(new ArrayList<>(ls));
            return;
        }
        if (i >= n || target < 0)
            return;
        ls.add(candidates[i]);
        sum(l, ls, candidates, i, target - candidates[i]);
        ls.remove(ls.size() - 1);
        sum(l, ls, candidates, i+1, target);
    }
}