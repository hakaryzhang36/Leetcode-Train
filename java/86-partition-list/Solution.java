// Leetcode 86-partition-list
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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode newHead1 = new ListNode();
        ListNode newHead2 = new ListNode();
        ListNode e1 = newHead1;
        ListNode e2 = newHead2;
        while (head != null) {
            ListNode t = head;
            head = head.next;
            if (t.val < x) {
                e1.next = t;
                e1 = e1.next;
                e1.next = null;
            }
            else {
                e2.next = t;
                e2 = e2.next;
                e2.next = null;
            }
        }
        e1.next = newHead2.next;
        return newHead1.next;
    }
}