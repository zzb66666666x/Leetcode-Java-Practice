/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        String res = Integer.toString(root.val);
        res+=",";
        String leftstr = serialize(root.left);
        res+=leftstr;
        res+=",";
        String rightstr = serialize(root.right);
        res+=rightstr;
        // System.out.println(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        ArrayDeque<String> q = new ArrayDeque<String>();
        for (String s : arr){
            q.offer(s);
        }
        return buildTree(q);
    }

    private TreeNode buildTree(ArrayDeque<String> q){
        String value = q.poll();
        if (value.equals("null")){
            return null;
        }
        int val = Integer.valueOf(value);
        TreeNode node = new TreeNode(val);
        node.left = buildTree(q);
        node.right = buildTree(q);
        return node;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
