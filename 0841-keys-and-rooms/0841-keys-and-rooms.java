class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] vis = new boolean[rooms.size()];
        vis[0] = true;
        dfs(rooms,0,vis);
        for(int i=0;i<rooms.size();i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
    void dfs(List<List<Integer>> rooms , int i , boolean [] vis){
        vis[i] = true;
        for(int nei : rooms.get(i)){
            if(!vis[nei]){
                vis[nei] = true;
                dfs(rooms,nei,vis);
            }
        }

    }
}