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
        ListNode head = new ListNode();
        ListNode end = head;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                end.next = list1;
                list1 = list1.next;
                end = end.next;
                end.next = null;
            }
            else{
                end.next = list2;
                list2 = list2.next;
                end = end.next;
                end.next = null;
            }
        }
        if(list1 != null) {
            end.next = list1;
        }
        if (list2 != null) {
            end.next = list2;
        }
        return head.next;
    }
}