// Leetcode 24-swap-nodes-in-pairs
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1, head);
        while (pre.next != null && pre.next.next != null) {
             switch
            ListNode a = pre.next, b = pre.next.next, t = pre.next.next.next;
            pre.next = b;
            b.next = a;
            a.next = t;
             change head node for the first loop
            if (a == head) {
                head = b;
            }
             update
            pre = a;
             System.out.println(b.next.val);
             System.out.println(a.next.val);
        }
        return head;
    }
}