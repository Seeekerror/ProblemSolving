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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        PathSum(root);
        return res;
    }
    int PathSum(TreeNode root){
        if(root == null) return 0;
        int left = PathSum(root.left);
        int right = PathSum(root.right);
        int node = root.val;
        int ans1=Math.max(left,right)+root.val;
        int ans2=left+right+node;
        res = Math.max(res,Math.max(node,Math.max(ans1,ans2)));
        return Math.max(ans1,node);
    }
}