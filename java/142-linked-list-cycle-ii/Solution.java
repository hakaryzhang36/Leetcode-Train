// Leetcode 142-linked-list-cycle-ii
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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode a = head, b = head;
        while(b != null) {
            a = a.next;
            b = b.next;
            if(b == null) return null;
            b = b.next;
            if (a == b) break;
        }
        if(b == null) return null;

        ListNode c = head;
        while(c != a) {
            c = c.next;
            a = a.next;
        }
        return c;
    }
}