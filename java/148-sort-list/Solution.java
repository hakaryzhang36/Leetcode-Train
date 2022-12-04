// Leetcode 148-sort-list
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
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = 0;
        for (ListNode node = head; node != null; node = node.next) {
            size++;
        }
        return mergeSort(head, size);
    }



    private ListNode mergeSort(ListNode head, int size) {
        // back
        if (size == 1) {
            return head;
        }

        // get mid
        ListNode mid = head;
        int i = 1;
        for (; i < size / 2; i++) {
            mid = mid.next;
        }


        // 切断，成为独立的两个链，不然会有循环
        ListNode end = mid;
        while (i < size) {
            end = end.next;
            i++;
        }
        end.next = null;
        ListNode rightHead = mid.next;
        mid.next = null;

        // split
        int ls = size / 2, rs = size - size / 2;
        ListNode leftNode = mergeSort(head, ls);
        ListNode rightNode = mergeSort(rightHead, rs);

        // merge
        ListNode newEnd = null;
        ListNode newHead = null;
        // 链上以归入新链的节点数
        int l = 0, r = 0;

        for (; l < ls && r < rs;) {
            if (leftNode.val < rightNode.val) {
                if (newEnd == null) {
                    newEnd = leftNode;
                }
                else {
                    newEnd.next = leftNode;
                    newEnd = newEnd.next;
                }

                leftNode = leftNode.next;
                l++;
                if (newHead == null) {
                    newHead = newEnd;
                }
            }
            else {
                // addNode(newEnd, rightNode);
                if (newEnd == null) {
                    newEnd = rightNode;
                }
                else {
                    newEnd.next = rightNode;
                    newEnd = newEnd.next;
                }

                rightNode = rightNode.next;
                r++;
                if (newHead == null) {
                    newHead = newEnd;
                }
            }
        }

        if (l < ls) {
            newEnd.next = leftNode;
        }
        if (r < rs) {
            newEnd.next = rightNode;
        }

        return newHead;
    }

}