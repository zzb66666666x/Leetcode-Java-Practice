/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode();
        ListNode nextnode = null;
        for (ListNode ptr = head; ptr != null; ){
            ListNode tmp = ptr.next;
            dummy.next = ptr;
            ptr.next = nextnode;
            nextnode = ptr;
            ptr = tmp;
        }
        return dummy.next;
    }
}
