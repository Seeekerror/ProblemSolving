class Solution {
    List<List<Integer>> l = new ArrayList<>();
    List<Integer> ls = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int [] ar = new int[9];
        for(int i=1;i<=9;i++){
            ar[i-1] = i;
        }
        solve(ar,k,0,n);
        return l;
    }
    void solve(int [] ar , int k , int i, int n){
        if(n == 0){
            if(ls.size() == k)
            l.add(new ArrayList<>(ls));
            return;
        }
        if(i >= ar.length) return;
        ls.add(ar[i]);
        if(ar[i] <= n){
            solve(ar,k,i+1,n-ar[i]);
        }
        ls.remove(ls.size()-1);
        solve(ar,k,i+1,n);
    }
}