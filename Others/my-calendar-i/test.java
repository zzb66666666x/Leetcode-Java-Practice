// method1: basic binary tree
// class TreeNode{
//     public int start;
//     public int end;
//     public TreeNode left = null;
//     public TreeNode right = null;

//     public TreeNode(int s, int e){
//         start = s;
//         end = e;
//     }
// }

// class MyCalendar {
//     private TreeNode treeroot = null;
//     public MyCalendar() {
//     }
    
//     public boolean book(int start, int end) {
//         // System.out.println(start + " " + end);
//         if (treeroot == null){
//             treeroot = new TreeNode(start, end);
//             return true;
//         }
//         TreeNode node = new TreeNode(start, end);
//         boolean ret = insert(treeroot, node);
//         System.out.println(ret);
//         return ret;
//     }

//     private boolean insert(TreeNode root, TreeNode node){
//         // System.out.println("check at "+root.start + " " + root.end);
//         // if (check(root, node) && check(node, root)){
//         if (check(root, node)){
//             if (node.start < root.start){
//                 // to left
//                 if (root.left == null){
//                     root.left = node;
//                     return true;
//                 }else{
//                     return insert(root.left, node);
//                 }
//             }else{
//                 // to right
//                 if (root.right == null){
//                     root.right = node;
//                     return true;
//                 }else{
//                     return insert(root.right, node);
//                 }
//             }
//         }else{
//             return false;
//         }
//     }

//     private boolean check(TreeNode node1, TreeNode node2){
//         if (Math.max(node1.start, node2.start) < Math.min(node1.end, node2.end)){
//             return false;
//         }
//         return true;
//     }
// }

// method2: segment tree
// class MyCalendar {

//     public MyCalendar() {

//     }
    
//     public boolean book(int start, int end) {
//         // 先查询该区间是否为 0
//         if (query(root, 0, N, start, end - 1) != 0) return false;
//         // 更新该区间
//         update(root, 0, N, start, end - 1, 1);
//         return true;
//     }
//     // *************** 下面是模版 ***************
//     class Node {
//         // 左右孩子节点
//         Node left, right;
//         // 当前节点值，以及懒惰标记的值
//         int val, add;
//     }
//     private int N = (int) 1e9;
//     private Node root = new Node();
//     public void update(Node node, int start, int end, int l, int r, int val) {
//         if (l <= start && end <= r) {
//             node.val += val;
//             node.add += val;
//             return ;
//         }
//         pushDown(node);
//         int mid = (start + end) >> 1;
//         if (l <= mid) update(node.left, start, mid, l, r, val);
//         if (r > mid) update(node.right, mid + 1, end, l, r, val);
//         pushUp(node);
//     }
//     public int query(Node node, int start, int end, int l, int r) {
//         if (l <= start && end <= r) return node.val;
//         pushDown(node);
//         int mid = (start + end) >> 1, ans = 0;
//         if (l <= mid) ans = query(node.left, start, mid, l, r);
//         if (r > mid) ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
//         return ans;
//     }
//     private void pushUp(Node node) {
//         // 每个节点存的是当前区间的最大值
//         node.val = Math.max(node.left.val, node.right.val);
//     }
//     private void pushDown(Node node) {
//         if (node.left == null) node.left = new Node();
//         if (node.right == null) node.right = new Node();
//         if (node.add == 0) return ;
//         node.left.val += node.add;
//         node.right.val += node.add;
//         node.left.add += node.add;
//         node.right.add += node.add;
//         node.add = 0;
//     }
// }

// 作者：lfool
// 链接：https://leetcode.cn/problems/my-calendar-i/solution/by-lfool-xvpv/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// method3: (easiest) TreeMap
class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */