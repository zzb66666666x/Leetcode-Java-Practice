/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[0];
        int len = 0;
        ListNode tmp = head;
        while (tmp != null){
            tmp = tmp.next;
            len++;
        }
        int [] ret = new int[len];
        int idx = len-1;
        tmp = head;
        while (tmp != null){
            ret[idx--] = tmp.val;
            tmp = tmp.next;
        }
        return ret;
    }
}