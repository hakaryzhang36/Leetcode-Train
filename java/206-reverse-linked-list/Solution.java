// Leetcode 206-reverse-linked-list
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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = head, p = head.next;
        newHead.next = null;
        while (p != null) {
            ListNode t = p.next;
            p.next = newHead;
            newHead = p;
            p = t;
        }
        return newHead;
    }
}