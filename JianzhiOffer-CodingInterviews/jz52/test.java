
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int len1 = getLen(headA);
        int len2 = getLen(headB);
        if (len1 != len2){
            if (len1 > len2){
                headA = move(headA, len1-len2);
            }else{  
                headB = move(headB, len2-len1);
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLen(ListNode node){
        int cnt = 0;
        while (node != null){
            cnt++;
            node = node.next;
        }
        return cnt;
    }

    private ListNode move(ListNode node, int offset){
        while (offset > 0){
            node = node.next;
            offset --;
        }
        return node;
    }
}

