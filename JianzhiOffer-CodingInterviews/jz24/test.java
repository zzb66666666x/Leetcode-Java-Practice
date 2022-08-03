/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // 头插法！
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null)
//             return null;
//         ListNode dummy = new ListNode(0);
//         ListNode nextnode = null;
//         while (head != null){
//             ListNode tmp = head.next;
//             dummy.next = head;
//             head.next = nextnode;
//             nextnode = head;
//             head = tmp;
//         }
//         return dummy.next;
//     }
// }

// 迭代, 省去分配dummy head的空间
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode nextnode = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = nextnode;
            nextnode = head;
            head = tmp;
        }
        return nextnode;
    }
}