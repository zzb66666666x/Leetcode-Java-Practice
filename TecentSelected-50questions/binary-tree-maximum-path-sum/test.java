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
import java.lang.Math;

class Solution {
    private int onlyleft = -10000;
    private int onlyright = -10000;
    private int lefttoright = -10000;

    private int dfs(TreeNode root){
        if (root == null){
            return -10000;
        }
        int leftval = dfs(root.left);
        int rightval = dfs(root.right);
        onlyleft = Math.max(onlyleft, leftval);
        onlyright = Math.max(onlyright, rightval);
        lefttoright = Math.max(lefttoright, leftval+rightval+root.val);
        int leftup = leftval+root.val;
        int rightup = rightval+root.val;
        int rootup = root.val;
        int ret = Math.max(Math.max(leftup, rightup), rootup);
        return ret;
    }

    public int maxPathSum(TreeNode root) {
        int ret = dfs(root);
        return Math.max(Math.max(onlyleft, onlyright), Math.max(lefttoright, ret));
    }
}