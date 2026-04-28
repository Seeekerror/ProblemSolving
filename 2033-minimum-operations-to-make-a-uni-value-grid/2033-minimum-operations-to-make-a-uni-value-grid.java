class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int arr[]=new int[n*m];
        int ind=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[ind++]=grid[i][j];
            }
        }

        Arrays.sort(arr);
        int res=arr[arr.length/2];
        int cnt=0;
        for(int i:arr){
            int temp=Math.abs(i-res);
            if(temp%x!=0) return -1;
            cnt+=temp/x;
        }
        return cnt;
    }
}