class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        int[] par = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            par[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    Union(i, j, par, rank);
                }
            }
        }

        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(par[i] == i) provinces++;
        }

        return provinces;
    }
    void Union(int u, int v, int [] par, int [] rank){
        int ul_pu = find(u,par);
        int ul_pv = find(v,par);
        if(ul_pu == ul_pv) return;
        if(rank[ul_pu] > rank[ul_pv]){
            par[ul_pv] = ul_pu;
        }else if(rank[ul_pu] < rank[ul_pv]){
            par[ul_pu] = ul_pv;
        }
        else{
            par[ul_pv] = ul_pu;
            rank[ul_pu]++;
        }
    }
    int find(int x, int [] par){

        if(par[x] == x) return x;
        return par[x] = find(par[x],par);
    }
}