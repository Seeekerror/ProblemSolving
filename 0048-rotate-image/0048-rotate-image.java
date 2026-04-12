class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int [][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            int x = 0;
            for(int j = n-1; j >= 0; j--){
                mat[i][x++] = matrix[j][i];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = mat[i][j];
            }
        }
    }
}