// Leetcode 92-reverse-linked-list-ii
// mark
// solve but slow
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
        ListNode L = null;
        ListNode R = null;
        ListNode l = null;
        ListNode r = null;
        ListNode pre = null;
        ListNode node = head;
        // 确定边界
        for (int i = 1; i <= right; i++) {
            if (i == left) {
                l = node;
                L = pre;
            }
            if(i == right){
                r = node;
                R = node.next;
            }
            pre = node;
            node = node.next;
        }
        // 连接头部
        if (L != null) {
            L.next = r;
        }
        else {
            head = r;
        }
        // 切断
        r.next = null;
        ListNode n1 = l;
        ListNode n2 = l.next;
        // 连接尾部
        n1.next = R;
        while (n2 != null) {
            ListNode t = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = t;
        }

        return head;
    }
}