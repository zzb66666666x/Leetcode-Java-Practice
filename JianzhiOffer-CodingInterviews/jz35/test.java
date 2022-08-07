/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// method1: method of hashtable
// import java.util.HashMap;

// class Solution {
//     private Node getNode(Node head, int idx){
//         while (idx>0){
//             head = head.next;
//             idx--;
//         }
//         return head;
//     }

//     public Node copyRandomList(Node head) {
//         if (head == null){
//             return null;
//         }
//         HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
//         int idx = 0;
//         Node temp = head;
//         Node newlist = null;
//         Node newhead = null;
//         Node newprev = null;
//         while(temp != null){
//             newlist = new Node(temp.val);
//             if (newhead == null){
//                 newhead = newlist;
//             }
//             if (newprev!=null){
//                 newprev.next = newlist;
//             }
//             newprev = newlist;
//             m.put(temp.hashCode(), idx);
//             idx++;
//             temp = temp.next;
//         }
//         temp = head;
//         newlist = newhead;
//         while (temp != null){
//             if (temp.random != null){
//                 newlist.random = getNode(newhead, m.get(temp.random.hashCode()));
//             }
//             temp = temp.next;
//             newlist = newlist.next;
//         }
//         return newhead;
//     }
// }

// method2: split interleaved linked list
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while(cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while(cur != null) {
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }
}

// 作者：jyd
// 链接：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-ha-xi-/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。