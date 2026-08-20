class Solution {
    List<List<Integer>> l = new ArrayList<>();
    List<Integer> ls = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(0,candidates,target);

        return l;
    }
    void solve(int i, int [] arr , int tar){
        if(tar == 0){
            l.add(new ArrayList<>(ls));
            return;
        }
        if(i >= arr.length) return;
        
        ls.add(arr[i]);
        if(arr[i] <= tar){
            solve(i+1,arr,tar-arr[i]);
        }
        ls.remove(ls.size()-1);
        int j = i+1;
        while(j < arr.length && arr[j] == arr[i]) j++;
        solve(j,arr,tar);
    }
}