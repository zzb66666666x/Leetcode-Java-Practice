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
        if (A == null || B==null)
            return false;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(A);
        while (q.isEmpty() == false){
            TreeNode node = q.getFirst();
            if (node.left != null){
                q.add(node.left);
            }
            if (node.right != null){
                q.add(node.right);
            }
            if (check(node, B))
                return true;
            q.removeFirst();
        }
        return false;
    }

    private boolean check(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 != null)
            return false;
        if (node1 == null && node2 == null) 
            return true;
        if (node2 == null)
            return true;
        System.out.println(node1.val + "  " + node2.val);
        if (node1.val != node2.val)
            return false;
        if (check(node1.left, node2.left) && check(node1.right, node2.right)){
            return true;
        }else{
            return false;
        }
    }
}
