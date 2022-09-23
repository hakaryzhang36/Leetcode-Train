// Leetcode 203-remove-linked-list-elements
class Solution {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        System.out.println(a.val);
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
   public ListNode removeElements(ListNode head, int val) {
       ListNode pre = head, node = head;
       while (node != null) {
           if (node.val == val) {
               if (node == head) {
                   head = node.next;
                   node = head;
                   pre = head;
               }
               else {
                   pre.next = node.next;
                   node = node.next;
               }
           }
           else {
               pre = node;
               node = node.next;
           }
       }
       return  head;
   }
}