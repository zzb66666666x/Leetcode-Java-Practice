/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Item{
    public Item(TreeNode n, int l){
        node = n;
        level = l;
    }
    public TreeNode node;
    public int level;
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null)
            return ret;
        LinkedList<Item> q = new LinkedList<Item>();
        q.add(new Item(root, 1));
        int curlevel = 1;
        List<Integer> curlist = new ArrayList<Integer>();
        while (q.isEmpty() == false){
            Item it = q.getFirst();
            // System.out.println(it.level);
            if (it.level > curlevel){
                ret.add(curlist);
                curlist = new ArrayList<Integer>();
                curlevel = it.level;
            }
            TreeNode node = it.node;
            if (node.left != null){
                q.addLast(new Item(node.left, curlevel+1));
            }
            if (node.right != null){
                q.addLast(new Item(node.right, curlevel+1));
            }
            curlist.add(node.val);
            q.removeFirst();
        }
        ret.add(curlist);
        return ret;
    }
}
