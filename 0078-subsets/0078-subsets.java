class Solution {
    List<List<Integer>> l = new ArrayList<>();
    List<Integer> ls = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums,0);
        return l;
    }
    void solve(int [] arr , int i){
        if(!l.contains(ls)){
            l.add(new ArrayList<>(ls));
        }
        if(i >= arr.length) return;
        ls.add(arr[i]);
        solve(arr,i+1);
        ls.remove(ls.size()-1);
        solve(arr,i+1);
    }
}