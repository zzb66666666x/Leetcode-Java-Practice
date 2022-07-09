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

    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        q.add(root);
        while (q.isEmpty() == false){
            TreeNode node = q.getFirst();
            if (node.left != null)
                q.addLast(node.left);
            if (node.right != null)
                q.addLast(node.right);
            output.add(node.val);
            q.removeFirst();
        }
        int[] ret = new int[output.size()];
        for (int i=0; i<output.size(); i++){
            ret[i] = output.get(i);
        }
        return ret;
    }
}