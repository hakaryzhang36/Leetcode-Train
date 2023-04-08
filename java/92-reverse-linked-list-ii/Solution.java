// Leetcode 92-reverse-linked-list-ii
// mark
// done but important
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode pre_start = null;
        ListNode start = null;
        ListNode end = null;
        for (int i = 1; i <= right; i++) {
            if (i == left) {
                pre_start = pre;
                
                start = cur;
            }
            if (i == right) {
                end = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        if (pre_start == null) {
            return reverse(start, end, pre_start, cur);
        }
        else {
            reverse(start, end, pre_start, cur);
            return head;
        }
    }

    public ListNode reverse(ListNode head, ListNode tail, ListNode pre, ListNode next) {
        ListNode a = head;
        ListNode b = head.next;
        a.next = next;
        while (a != tail) {
            ListNode t = b.next;
            b.next = a;
            a = b;
            b = t;
        }
        if (pre != null) {
            pre.next = tail;
        }
        return tail;
    }
}