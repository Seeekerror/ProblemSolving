class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int l = 0;
            int r = matrix[i].length-1;
            while(l <= r){
                int mid = l + (r - l)/2;
                if(matrix[i][mid] == target){
                    return true;
                }else if(matrix[i][mid] < target){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}