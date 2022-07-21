
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// method1: brute force search with dfs 
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

// method2: use the property of binary search tree!!!!
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        
        // 要么比pq都大，要么比pq都小
        // 夹在中间时，返回这个节点！
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}


