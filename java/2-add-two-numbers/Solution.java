// Leetcode 2-add-two-numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = l1;
        int up = 0;
        ListNode last1 = l1, last2 = l2;
        while (l1 != null && l2 != null) {
            if (l1 != null && l2 != null) {
                l1.val = l1.val + l2.val + up;
            }
            if (l1.val >= 10) {
                up = 1;
                l1.val = l1.val % 10;   
            }
            else {
                up = 0;
            }
            last1 = l1;
            last2 = l2;
            l1 = l1.next;
            l2 = l2.next;
        }

        // 将l2多出来的部分接在l1上
        if (l2 != null) {
            last1.next = l2;
            l1 = l2;
            
        }

        // 多出来的部分继续计算
        while (l1 != null && up == 1) {
            l1.val = l1.val + up;
            if (l1.val >= 10) {
                up = 1;
                l1.val = l1.val % 10;   
            }
            else {
                up = 0;
            }
            last1 = l1;
            l1 = l1.next;
        }
        if (up == 1) {
            last1.next = new ListNode(1);
        }

        return res;
    }
}