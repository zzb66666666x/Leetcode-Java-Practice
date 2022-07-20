/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int maxdepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        maxdepth = 1;
        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int depth){
        if (node == null)
            return depth-1;
        int depth1 = dfs(node.left, depth+1);
        int depth2 = dfs(node.right, depth+1);
        maxdepth = Math.max(maxdepth, Math.max(depth1, depth2));
        return maxdepth;
    }
}
