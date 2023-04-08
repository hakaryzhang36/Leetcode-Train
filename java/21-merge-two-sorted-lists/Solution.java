// Leetcode 21-merge-two-sorted-lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null && list2 != null) return list2;
        if (list1 != null && list2 == null) return list1;
        
        ListNode res = null;
        ListNode cur = null;
        for(; list1 != null && list2 != null;) {
            if (list1.val > list2.val) {
                if (cur == null) {
                    cur = list2;
                    list2 = list2.next;
                    res = cur;
                }
                else {
                    cur.next = list2;
                    cur = cur.next;
                    list2 = list2.next;
                    cur.next = null;
                }
            }
            else {
                if (cur == null) {
                    cur = list1;
                    res = cur;
                    list1 = list1.next;
                }
                else {
                    cur.next = list1;
                    cur = cur.next;
                    list1 = list1.next;
                    cur.next = null;
                }
            }
        }
        if (list1 != null) {
            cur.next = list1;
            return res;
        }
        else {
            cur.next = list2;
            return res;
        }
    }
}