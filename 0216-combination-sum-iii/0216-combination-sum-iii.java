class Solution {
    List<List<Integer>> l;
    public List<List<Integer>> combinationSum3(int k, int n) {
        l = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        backtrack(k,n,ls,0,1);
        return l;
    }
    void backtrack(int k, int n, List<Integer> ls, int sum, int i){
        if(i > 9){
            if(ls.size() == k){
                if(sum == n){
                    l.add(new ArrayList<>(ls));
                }
            }
            return;
        }
        ls.add(i);
        backtrack(k,n,ls,sum+i,i+1);
        ls.remove(ls.size()-1);
        backtrack(k,n,ls,sum,i+1);
    }
}