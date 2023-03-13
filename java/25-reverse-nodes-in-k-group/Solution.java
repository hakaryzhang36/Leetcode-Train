// Leetcode 25-reverse-nodes-in-k-group
// mark
// HARD IN DETAIL
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
        ListNode resHead = null;
        ListNode h = head;      // 反转前头节点   
        ListNode e = head;      // 反转前尾节点
        ListNode f = null;     // 前一段链表尾节点
        ListNode b = null;
        while (e != null) {
            // 确定 e 位置
            for (int i = 1; e != null && i < k; i++) {
                e = e.next;
            }

            // 到头
            if (e == null) {
                break;
            }
            b = e.next;

            // 确定最终头节点
            if (resHead == null) {
                resHead = e;
            }

            // 标记前指针、后指针
            ListNode pre = h;
            ListNode p = h.next;

            // 前后指针完成反转
            for (int i = 2; i <= k; i++) {
                ListNode t = p.next;
                p.next = pre;
                pre = p;
                p = t;
            }
            // 前一段连上尾节点
            if (f != null) {
                f.next = e;
            }
            h.next = b;
            
            // new start
            f = h;
            h = b;
            e = b;
        }
        return resHead;
    }
}