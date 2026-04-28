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
        int mod = arr[0] % x;
        for (int val : arr) {
            if (val % x != mod) return -1;
        }
        int num = arr[m*n/2];
        int count=0;
        for(int i = 0; i<arr.length; i++)
            count += Math.abs(arr[i]-num)/x;
        
        return count;
    }
}