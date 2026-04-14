class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int top = 0, bottom = m,left = 0, right = n;
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                l.add(matrix[top][i]);
            }
            top++;

            for(int j = top; j <= bottom; j++){
                l.add(matrix[j][right]);
            }
            right--;

            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    l.add(matrix[bottom][i]);
                }
            }
            bottom--;

            if(left <= right){
                for(int j = bottom; j >= top; j--){
                    l.add(matrix[j][left]);
                }
            }
            left++;
        }
        return l;
    }
}