class Solution {
    int m,n;
    boolean [][] vis;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        vis = new boolean[m][n];

        for(int i = 0; i < n; i++){
            if(!vis[0][i] && board[0][i] == 'O'){
                dfs(board,0,i,vis);
            }
        }
        for(int i = 0; i < m; i++){
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(board,i,0,vis);
            }
        }
        for(int i = 0; i < n; i++){
            if(!vis[m-1][i] && board[m-1][i] == 'O'){
                dfs(board,m-1,i,vis);
            }
        }
        for(int i = 0; i < m; i++){
            if(!vis[i][n-1] && board[i][n-1] == 'O'){
                dfs(board,i,n-1,vis);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    dfs2(board,i,j,vis);
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    void dfs2(char [][] board, int r, int c, boolean [][] vis){
        if(r < 0 || r >= m || c < 0 || c >= n || vis[r][c] || board[r][c] == 'X') return;
        board[r][c] = 'X';
        vis[r][c] = true;
        dfs2(board,r+1,c,vis);
        dfs2(board,r-1,c,vis);
        dfs2(board,r,c-1,vis);
        dfs2(board,r,c+1,vis);
    }
    void dfs(char [][] board, int r, int c, boolean [][] vis){
        if(r < 0 || r >= m || c < 0 || c >= n || vis[r][c] || board[r][c] == 'X') return;
        board[r][c] = 'Y';
        vis[r][c] = true;
        dfs(board,r+1,c,vis);
        dfs(board,r-1,c,vis);
        dfs(board,r,c-1,vis);
        dfs(board,r,c+1,vis);

    }
}