/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode prev = null;
        while (head.next != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head.next=prev;
        return head;
    }
}