// Leetcode 160-intersection-of-two-linked-lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 1, lenB = 1;
        ListNode headAm = headA, headBm = headB;
        while (headA.next != null) {
            headA = headA.next;
            lenA++;
        }
        while (headB.next != null) {
            headB = headB.next;
            lenB++;
        }

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                headAm = headAm.next;
            }
        }

        if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++) {
                headBm = headBm.next;
            }
        }

        while (headAm != null) {
            if (headAm == headBm) {
                return headAm;
            }
            headAm = headAm.next;
            headBm = headBm.next;
        }

        return null;
    }
}