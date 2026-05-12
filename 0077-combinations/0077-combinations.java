class Solution {
    List<List<Integer>> l;
    public List<List<Integer>> combine(int n, int k) {
        l = new ArrayList<>();
        backtrack(n,k,1,new ArrayList<>());
        return l;
    }
    void backtrack(int n, int k, int j, ArrayList<Integer> ls){
        if(ls.size() == k){
            l.add(new ArrayList<>(ls));
            return;
        }
        for(int i=j;i<=n;i++){
            ls.add(i);
            backtrack(n,k,i+1,ls);
            ls.remove(ls.size()-1);
        }
    }
}