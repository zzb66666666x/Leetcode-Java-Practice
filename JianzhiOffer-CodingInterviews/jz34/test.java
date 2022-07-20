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
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null)
            return new ArrayList<List<Integer>>();
        return dfs(root, target);
    }

    ArrayList<List<Integer>> dfs(TreeNode node, int target){
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (node.left == null && node.right == null){
            // reach leaf node
            if (target == node.val){
                ArrayList<Integer> path = new ArrayList<Integer>();
                path.add(0, node.val);
                ret.add(path);
            }
            return ret;
        }
        if (node.left != null){
            ArrayList<List<Integer>> paths1 = dfs(node.left, target-node.val);
            for (int i=0; i<paths1.size(); i++){
                List<Integer> path = paths1.get(i);
                path.add(0, node.val);
                ret.add(path);
            }
        }
        if (node.right != null){
            ArrayList<List<Integer>> paths2 = dfs(node.right, target-node.val);
            for (int i=0; i<paths2.size(); i++){
                List<Integer> path = paths2.get(i);
                path.add(0, node.val);
                ret.add(path);
            }
        }
        return ret;
    }
}
