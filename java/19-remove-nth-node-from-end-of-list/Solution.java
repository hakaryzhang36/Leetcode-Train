// Leetcode 19-remove-nth-node-from-end-of-list
// mark
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
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 1; i < n; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode cur = head, pre = null;
        // move cur to the last n node
        while(tail.next != null) {
            pre = cur;
            tail = tail.next;
            cur = cur.next;
        }
        // remove cur node
        if (pre != null) {
            pre.next = cur.next;
        }
        else {
            head = head.next;
        }
        return head;
        
    }
}