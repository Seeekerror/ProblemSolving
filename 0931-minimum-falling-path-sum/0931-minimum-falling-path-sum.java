class Solution {
    int [][] dp;
    public int minFallingPathSum(int[][] matrix) {
        dp = new int[matrix.length][matrix.length];
        for(int [] row : dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<matrix.length;j++){
            int res = solve(matrix,0,j);
            ans = Math.min(res,ans);
        }
        return ans;
    }
    int solve(int [][] matrix , int i , int j){
        if(i >= matrix.length || j >= matrix.length || j < 0) return Integer.MAX_VALUE;
        if(i == matrix.length-1) return matrix[i][j];
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int f = solve(matrix,i+1,j-1);
        int s = solve(matrix,i+1,j);
        int t = solve(matrix,i+1,j+1);
        return dp[i][j] = matrix[i][j] + Math.min(f,Math.min(s,t));
    }
}