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
    private boolean flag;

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        flag = true;
        dfs(root, 1);
        return flag;
    }

    private int dfs(TreeNode node, int depth){
        if (node == null)
            return depth-1;
        int depth1 = dfs(node.left, depth+1);
        int depth2 = dfs(node.right, depth+1);
        if (Math.abs(depth1 - depth2)>1)
            flag = false;
        return Math.max(depth1, depth2);
    }
}
