class NumMatrix {
    int mat[][];
    int ans[][];

    public NumMatrix(int[][] matrix) {
        mat = matrix;
        ans = new int[mat.length][mat[0].length];
        ans[0][0] = mat[0][0];
        fill(0, 0);
    }

    public void fill(int r, int c) {
        if (r >= mat.length)
            return;
        if (c >= mat[0].length) {
            fill(r + 1, 0);
            return;
        }

        int up = (r > 0) ? ans[r - 1][c] : 0;
        int left = (c > 0) ? ans[r][c - 1] : 0;
        int diag = (r > 0 && c > 0) ? ans[r - 1][c - 1] : 0;

        ans[r][c] = mat[r][c] + up + left - diag;

        fill(r, c + 1);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return ans[row2][col2] + ans[row1 - 1][col1 - 1] - ans[row1 - 1][col2] - ans[row2][col1 - 1];

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */