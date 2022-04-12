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
import java.util.HashMap;

class Solution {
    private Node getNode(Node head, int idx){
        while (idx>0){
            head = head.next;
            idx--;
        }
        return head;
    }

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int idx = 0;
        Node temp = head;
        Node newlist = null;
        Node newhead = null;
        Node newprev = null;
        while(temp != null){
            newlist = new Node(temp.val);
            if (newhead == null){
                newhead = newlist;
            }
            if (newprev!=null){
                newprev.next = newlist;
            }
            newprev = newlist;
            m.put(temp.hashCode(), idx);
            idx++;
            temp = temp.next;
        }
        temp = head;
        newlist = newhead;
        while (temp != null){
            if (temp.random != null){
                newlist.random = getNode(newhead, m.get(temp.random.hashCode()));
            }
            temp = temp.next;
            newlist = newlist.next;
        }
        return newhead;
    }
}