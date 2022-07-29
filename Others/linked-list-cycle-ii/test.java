
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // hashmap method
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         HashMap<Integer, ListNode> m = new HashMap<>();
//         while (head != null){
//             if (m.containsKey(head.hashCode()))
//                 return head;
//             m.put(head.hashCode(), head);
//             head = head.next;
//         }
//         return null;
//     }
// }

// better method: car crash!
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // fast slow pointer
        if (head == null)
            return null;
        boolean hasCircle = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                hasCircle = true;
                break;
            }
        }
        ListNode ptr = head;
        if (hasCircle){
            while (ptr != slow){
                ptr = ptr.next;
                slow = slow.next;
            }
        }else{
            return null;
        }
        return ptr;
    }
}
