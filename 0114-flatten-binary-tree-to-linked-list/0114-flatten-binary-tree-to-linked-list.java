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
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        //TreeNode node = new TreeNode(l.get(0));
        dfs(root);//preorder 
        int size=list.size();
        for(int i=0;i<size-1;i++){
            TreeNode first=list.get(i);
            TreeNode next=list.get(i+1);
            first.left=null;
            first.right=next;
            first=next;
            if(i==size-1){
                first.left=null;
                first.right=null;
            }
        }
        

        
    }
    void dfs(TreeNode root){
        if(root == null)return;
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
} 