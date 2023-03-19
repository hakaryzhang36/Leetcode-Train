// Leetcode 02.05-sum-lists-lcci
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode f = new ListNode();
        f.next = l1;
        add(l1,l2,0,f);
        return l1;
    }

    public void add(ListNode l1, ListNode l2, int up, ListNode f) {
        if (l1 == null && l2 == null) {
            if (up == 1) {
                f.next = new ListNode(1);
            }
            return;
        }
        if (l1 == null && l2 != null) {
            f.next = l2;
            if (up == 1) {
                f.next.val += 1;
            }
            add(l1, l2.next, upValue(f.next), f.next);
            return;
        }
        else if (l1 != null && l2 == null) {
            if (up == 1) {
                f.next.val += 1;
            }
            add(l1.next, l2, upValue(f.next), f.next);
            return;
        }
        else {
            f.next.val = l1.val + l2.val + up;
            add(l1.next, l2.next, upValue(f.next), f.next);
        }
        return;
    }

    private int upValue(ListNode node) {
        if (node.val >= 10) {
            node.val -= 10;
            return 1;
        }
        else {
            return 0;
        }
    }
}