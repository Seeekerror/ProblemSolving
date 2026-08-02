class Solution {
    int [][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int [] row : dp) Arrays.fill(row,Integer.MIN_VALUE);
        return solve(triangle , 0 , 0);
    }
    int solve(List<List<Integer>> tri , int i , int j){
        if(i >= tri.size() || j >= tri.get(i).size()) return Integer.MAX_VALUE;
        if(i == tri.size()-1) return tri.get(i).get(j);
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int f = solve(tri , i+1 , j);
        int s = solve(tri , i+1 , j+1);
        return dp[i][j] = tri.get(i).get(j) + Math.min(f,s);
    }
}