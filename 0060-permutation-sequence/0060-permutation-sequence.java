class Solution {
    int c=0;
    String str="";
    public String getPermutation(int n, int k) {
        boolean [] vis = new boolean[n+1];
        back(n,k,new StringBuilder(), vis);
        return str;
    }
    void back(int n,int k,StringBuilder sb,boolean [] vis){
        if(sb.length() == n){
            c++;
            if(c == k){
                str = sb.toString();
            }
            return;
        }
        for(int i = 1; i <= n; i++){
            if(vis[i]) continue;
            vis[i] = true;
            sb.append(i);
            back(n,k,sb,vis);
            sb.deleteCharAt(sb.length() - 1);
            vis[i] = false;
        }
    }
}