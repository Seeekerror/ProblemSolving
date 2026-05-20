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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> l = new ArrayList<>();
        dfs(root, l);
        List<List<Integer>> ls = new ArrayList<>();
        if (root == null)
            return ls;
        for (int i = 0; i < queries.size(); i++) {
            int low = 0;
            int high = l.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (l.get(mid) >= queries.get(i)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            int max = -1;
            int min = -1;
            if (low < l.size()) {
                max = l.get(low);
            }
            if (low - 1 >= 0) {
                min = l.get(low - 1);
            }
            if(low < l.size() && l.get(low).equals(queries.get(i))){
                min = queries.get(i);
                max = queries.get(i);
            }
            ls.add(Arrays.asList(min, max));
        }
        return ls;
    }

    void dfs(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        dfs(root.left, l);
        l.add(root.val);
        dfs(root.right, l);
    }
}