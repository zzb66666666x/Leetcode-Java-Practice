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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return checkTree(root.left, root.right);
    }
    private boolean checkTree(TreeNode L, TreeNode R){
        if (L == null && R == null)
            return true;
        if (L == null || R == null) 
            return false;
        if (L.val != R.val)
            return false;
        return checkTree(L.left, R.right) && checkTree(L.right, R.left);
     }
}
