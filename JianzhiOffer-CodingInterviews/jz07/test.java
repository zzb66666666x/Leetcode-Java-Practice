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
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length==0 || inorder.length==0)
            return null;
        for (int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        int[] progress = new int[]{0};
        return build(preorder, inorder, progress, 0, inorder.length-1);
    }

    private TreeNode build(int[] pre, int[] in, int[] preK, int inL, int inR){
        if (inL > inR || preK[0]>pre.length-1)
            return null;
        int rootval = pre[preK[0]];
        preK[0]++;
        int rootidx = map.get(rootval);
        if (rootidx < inL || rootidx > inR)
            System.out.println("Something wrong!");
        TreeNode node = new TreeNode(rootval);
        node.left = build(pre, in, preK, inL, rootidx-1);
        node.right = build(pre, in, preK, rootidx+1, inR);
        return node;
    }
}
