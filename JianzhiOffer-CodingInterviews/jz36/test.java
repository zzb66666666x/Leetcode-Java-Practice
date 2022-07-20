/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Report{
    public Node minNode;
    public Node maxNode;
    public Report(Node a, Node b){
        minNode = a;
        maxNode = b;
    }
}

class Solution {
    private Node head = null;
    private Node end = null;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        head = root;
        end = root;
        recur(root);
        head.left = end;
        end.right = head;
        return head;
    }

    public Report recur(Node node) {
        // System.out.println(node.val);
        if (node.left == null && node.right == null)
            return new Report(node, node);
        Report ret = new Report(node, node);
        if (node.left != null){
            Report r = recur(node.left);
            r.maxNode.right = node;
            node.left = r.maxNode;
            ret.minNode = r.minNode;
        }
        if (node.right != null){
            Report r = recur(node.right);
            r.minNode.left = node;
            node.right = r.minNode;
            ret.maxNode = r.maxNode;
        }
        head = ret.minNode.val < head.val? ret.minNode : head;
        end = ret.maxNode.val > end.val? ret.maxNode : end;
        return ret;
    }
}
