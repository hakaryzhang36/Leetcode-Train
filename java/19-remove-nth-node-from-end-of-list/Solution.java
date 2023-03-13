// Leetcode 19-remove-nth-node-from-end-of-list
// mark
// done
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nj = head;
        ListNode ni = head;
        ListNode p = null;
        for (int k = 1; k < n && nj.next != null; k++) {
            nj = nj.next;
        }
        while (nj.next != null) {
            p = ni;
            ni = ni.next;
            nj = nj.next;
        }
        if (ni == head) {
            return ni.next;
        }
        else {
            p.next = ni.next;
            return head;
        }
    }
}