// Leetcode 142-linked-list-cycle-ii
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b= head;
        int stepA = 1, stepB = 1;
        do {
            if(b.next != null && b.next.next != null) {
                b = b.next.next;
                stepB += 2;
            }
            else {
                return null;
            }
            a = a.next;
            stepA += 2;
        } while (a != b);
        b = head;
        while (b != a) {
            b = b.next;
            a = a.next;
        }
        return a;
    }
}