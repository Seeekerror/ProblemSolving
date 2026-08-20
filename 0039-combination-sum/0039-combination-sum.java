class Solution {
    List<List<Integer>> l = new ArrayList<>();
    List<Integer> ls = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(0, candidates, target);
        return l;
    }

    void solve(int i, int[] arr, int tar) {
        if (tar == 0) {
            l.add(new ArrayList<>(ls));
            return;
        }
        if (i >= arr.length) {
            return;
        }
        ls.add(arr[i]);
        if (arr[i] <= tar) {
            solve(i, arr, tar - arr[i]);
        }
        ls.remove(ls.size() - 1);
        solve(i + 1, arr, tar);
    }
}