// Leetcode 138-copy-list-with-random-pointer
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        return getCopyNode(head);
    }

    public Node getCopyNode(Node origin) {
        if (origin == null) {
            return null;
        }
        if (map.containsKey(origin)) {
            return map.get(origin);
        }
        else {
            Node copy = new Node(origin.val);
            map.put(origin, copy);
            copy.next = getCopyNode(origin.next);
            copy.random = getCopyNode(origin.random);
            return copy;
        }
    }
}