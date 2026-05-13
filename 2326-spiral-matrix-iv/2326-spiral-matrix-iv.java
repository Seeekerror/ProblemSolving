/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        if(head == null) return new int[][]{};
        int [][] mat = new int[m][n];
        for(int [] row : mat){
            Arrays.fill(row,-1);
        }
        int top=0,left=0,right=n-1,bottom=m-1;
        while(top <= bottom && left <= right && head != null){
            for(int j=left; j<=right && head != null; j++){
                mat[top][j] = head.val;
                head = head.next;
            }
            top++;
            for(int j=top;j<=bottom && head != null;j++){
                mat[j][right] = head.val;
                head = head.next;

            }
            right--;
            if(right >= 0){
                for(int i=right;i>=left && head != null;i--){
                    mat[bottom][i] = head.val;
                    head = head.next;

                }
            }
            bottom--;
            if(bottom >= 0){
                for(int i=bottom ;i>=top && head != null;i--){
                    mat[i][left] = head.val;
                    head = head.next;

                }
            }
            left++;
        }
        return mat;
    }
}