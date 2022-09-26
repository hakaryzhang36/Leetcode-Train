// Leetcode 02.07-intersection-of-two-linked-lists-lcci
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode firstA = headA, firstB = headB;
        // move to one list to the end
        while (firstA.next != null && firstB.next != null) {
            firstA = firstA.next;
            firstB = firstB.next;
        }
        // move the longer list's second node
        ListNode secondA = headA, secondB = headB;
        while (firstA.next != null) {
            firstA = firstA.next;
            secondA = secondA.next;
        }
        while (firstB.next != null) {
            firstB = firstB.next;
            secondB = secondB.next;
        }
        while (secondA != null) {
            if (secondA == secondB) {
                return secondA;
            }
            else {
                secondA = secondA.next;
                secondB = secondB.next;
            }
        }
        return null;
    }
}