class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] vis = new boolean[rooms.size()];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        vis[0] = true;

        while(!st.isEmpty()){

            int num = st.pop();

            for(int v : rooms.get(num)){
                if(!vis[v]){
                    vis[v] = true;
                    st.push(v);
                }
            }
        }

        for(boolean v : vis){
            if(!v) return false;
        }

        return true;
    }
}