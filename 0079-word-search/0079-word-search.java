class Solution {
    boolean [][] vis;
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        vis = new boolean[n][m];
        // ArrayList<String> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(solve(board,word,i,j,"",0)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean solve(char [][] grid , String word , int i , int j, String st,int idx){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j]) return false;
        if(grid[i][j] != word.charAt(idx)){
            return false;
        }
        if(idx == word.length()-1){
            return true;
        }
        vis[i][j] = true;
        boolean f = solve(grid,word,i-1,j,st,idx+1);
        boolean s = solve(grid,word,i+1,j,st,idx+1);
        boolean t = solve(grid,word,i,j-1,st,idx+1);
        boolean fr = solve(grid,word,i,j+1,st,idx+1);
        vis[i][j] = false;
        return f || s || t || fr;
    }
}