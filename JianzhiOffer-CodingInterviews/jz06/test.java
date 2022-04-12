/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.Stack;

class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<Integer>();
        while(head != null){
            s.push(head.val);
            head = head.next;
        }
        int length = s.size();
        int retarr[] = new int[length];
        int cnt=0;
        while(s.empty()==false){
            retarr[cnt]=s.pop();
            cnt++;
        }
        return retarr;
    }
}