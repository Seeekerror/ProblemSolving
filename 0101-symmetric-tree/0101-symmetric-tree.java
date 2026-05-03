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
    public boolean isSymmetric(TreeNode root) {
      if(root == null) return true;
      return sym(root.left , root.right); 
    }
    boolean sym(TreeNode lft , TreeNode ryt){
        if(lft == null && ryt == null) return true;
        if(lft == null || ryt == null) return false;
        if(lft.val != ryt.val) return false;
        return sym(lft.left , ryt.right) && sym(lft.right ,ryt.left);
    }
}