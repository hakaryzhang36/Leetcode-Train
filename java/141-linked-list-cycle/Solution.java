// Leetcode 141-linked-list-cycle
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
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode a = head, b = head.next;
        while (b != null) {
            if (a == b) {
                return true;
            }
            a = a.next;
            b = b.next;
            if (b != null) {
                b = b.next;
            }
            else {
                return false;
            }
        }
        return false;
    }
}