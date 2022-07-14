/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode node = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null || p2 != null){
            if (p1 == null || (p2 != null && p2.val < p1.val)){
                ListNode newnode = new ListNode(p2.val);
                node.next = newnode;
                p2 = p2.next;
            }else if (p2 == null || p1.val <= p2.val){
                ListNode newnode = new ListNode(p1.val);
                node.next = newnode;
                p1 = p1.next;
            }
            node = node.next;
        }
        return head.next;
    }
}
