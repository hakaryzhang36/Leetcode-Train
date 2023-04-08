// Leetcode 234-palindrome-linked-list
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        // 统计长度
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        // 找到第一个链表尾节点
        int k = 1;
        cur = head;
        while (k != count/2) {
            cur = cur.next;
            k++;
        }

        // 确定两个链表头节点
        ListNode l1 = head;
        ListNode l2 = count%2 == 0 ? cur.next : cur.next.next;
        cur.next = null;

        // 反转链表l1
        ListNode p = l1;
        ListNode q = l1.next;
        p.next = null;
        while (q != null) {
            ListNode t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        l1 = p;

        // 判断
        while (l1 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}