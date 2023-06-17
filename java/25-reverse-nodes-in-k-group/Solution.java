// Leetcode 25-reverse-nodes-in-k-group
// mark
// HARD IN DETAIL. Happy redo ^_^
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p, q, newHead = null, newEnd = null;
        p = head;
        while (p != null) {
            q = getQ(p, k);
            if (q == null) {
                if (p == head) return head;
                else {
                    newEnd.next = p;
                    return newHead;
                }
            } 
            ListNode pt = q.next;
            q.next = null;
            reverse(p);
            
            if (newHead == null) newHead = q;
            if (newEnd == null) newEnd = p;
            else {
                newEnd.next = q;
                newEnd = p;
            }
            p = pt;
        }
        return newHead;
    }

    public ListNode getQ(ListNode p, int k) {
        int c = 1;
        ListNode q = p;
        while(c < k) {
            if (q.next == null) return null;
            q = q.next;
            c++;
        }
        return q;
    }

    public void reverse(ListNode p) {
        ListNode prev = null;
        while (p != null) {
            ListNode n = p.next;
            p.next = prev;
            prev = p;
            p = n;
        }
    }
}