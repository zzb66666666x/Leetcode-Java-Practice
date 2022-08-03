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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A != null && B != null){
            // Maybe this A B are the two roots
            // if not, the || operator connects other trials
            return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }else{//约定空树不是任意一个树的子结构
            return false;
        }
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
