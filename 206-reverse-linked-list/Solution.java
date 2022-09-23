// Leetcode 206-reverse-linked-list
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        if (pre == null || pre.next == null) {
            return head;
        }
        
        ListNode cur = pre.next;
        pre.next = null;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }
}