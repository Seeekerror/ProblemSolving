class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length;
        int [] comp = new int[nums.length];
        comp[0] = 0;
        int id=0;
        for(int i=1;i<n;i++){
            if(nums[i] - nums[i-1] > maxDiff) id++;
            comp[i] = id;
        }
        boolean [] ans = new boolean[m];
        for(int i=0;i<m;i++){
            int [] x = queries[i];
            int u = x[0];
            int v = x[1];
            if(comp[u] == comp[v]){
                ans[i] = true;
            }else{
                ans[i] = false;
            }
        }
        return ans;
    }
}