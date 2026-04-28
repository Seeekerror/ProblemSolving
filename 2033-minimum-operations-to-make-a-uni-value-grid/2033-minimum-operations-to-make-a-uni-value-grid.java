class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[m * n];
        int idx=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr[idx++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        //int base = l.get(0);
        int num = arr[m*n/2];
        int count=0;
        for(int i = 0; i<arr.length; i++){
            int val = arr[i];
            if((val - num) % x != 0) return -1;
            count += Math.abs(val-num)/x;
        }
        return count;
    }
}