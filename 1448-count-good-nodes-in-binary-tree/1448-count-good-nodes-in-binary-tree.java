/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count;
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        count = 0;
        preorder(root,max);
        return count;
    }
    void preorder(TreeNode root,int max){
        if(root == null) return;
        if(root.val >= max) count++;
        max = Math.max(root.val,max);
        preorder(root.left,max);
        preorder(root.right,max);
    }
}