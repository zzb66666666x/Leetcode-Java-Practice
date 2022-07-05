class TreeNode{
    public int start;
    public int end;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int s, int e){
        start = s;
        end = e;
    }
}

class MyCalendar {
    private TreeNode treeroot = null;
    public MyCalendar() {
    }
    
    public boolean book(int start, int end) {
        // System.out.println(start + " " + end);
        if (treeroot == null){
            treeroot = new TreeNode(start, end);
            return true;
        }
        TreeNode node = new TreeNode(start, end);
        boolean ret = insert(treeroot, node);
        System.out.println(ret);
        return ret;
    }

    private boolean insert(TreeNode root, TreeNode node){
        // System.out.println("check at "+root.start + " " + root.end);
        if (check(root, node) && check(node, root)){
            if (node.start < root.start){
                // to left
                if (root.left == null){
                    root.left = node;
                    return true;
                }else{
                    return insert(root.left, node);
                }
            }else{
                // to right
                if (root.right == null){
                    root.right = node;
                    return true;
                }else{
                    return insert(root.right, node);
                }
            }
        }else{
            return false;
        }
    }

    private boolean check(TreeNode node1, TreeNode node2){
        if ((node1.start <= node2.start && node1.end > node2.start) || (node1.start < node2.end && node1.end >= node2.end)){
            return false;
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */