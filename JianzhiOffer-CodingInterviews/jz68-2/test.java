/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // use brute force with dfs since the tree here is not binary search tree
 // my solution
// class Solution {
//     class Item{
//         int rep;
//         TreeNode node;
//         int depth;
//     }
//     private HashMap<Integer, Item> map = new HashMap<>();

//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null)
//             return null;
//         dfs(root, p, q, 1);
//         // System.out.println(map.size());
//         Iterator<Integer> it = map.keySet().iterator();
//         int mdepth = 0;
//         TreeNode ret = null;
//         while (it.hasNext()){
//             int key = it.next();
//             Item item = map.get(key);
//             // System.out.println("key="+key+" rep="+item.rep);
//             if (item.rep != 2)
//                 continue;
//             if (item.depth > mdepth){
//                 mdepth = item.depth;
//                 ret = item.node;
//             }
//         }  
//         return ret; 
//     }

//     private int[] dfs(TreeNode node, TreeNode p, TreeNode q, int depth){
//         if (node == null)
//             return new int[2];
//         int[] ret1 = dfs(node.left, p, q, depth+1);
//         int[] ret2 = dfs(node.right, p, q, depth+1);
//         int[] ret = new int[2];
//         if (node.val == p.val){
//             ret[0] = 1;
//         }else{
//             ret[0] = Math.max(ret1[0], ret2[0]);
//         }
//         if (node.val == q.val){
//             ret[1] = 1;
//         }else{
//             ret[1] = Math.max(ret1[1], ret2[1]);
//         }
//         if (ret[0] == 1 || ret[1] == 1){
//             Item item = new Item();
//             item.rep = ret[0]+ret[1];
//             item.depth = depth;
//             item.node = node;
//             map.put(node.val, item);
//         }
//         return ret;
//     }
// }

// better solution found in comments
class Solution {
    /**
     * 二叉树的最近公共祖先
     * 思路：
     * 三种情况：
     * 1、p q 一个在左子树 一个在右子树 那么当前节点即是最近公共祖先
     * 2、p q 都在左子树 
     * 3、p q 都在右子树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // p q 一个在左，一个在右
            return root;
        }
        if (left != null) {
            // p q 都在左子树
            return left;
        }
        if (right != null) {
            // p q 都在右子树
            return right;
        }
        return null;
    }
}
