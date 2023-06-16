// Leetcode 146-lru-cache
class LRUCache {
    class Node {
        Node prev;
        Node next;
        Integer key;
        Integer value;
    }
    Node head = null;
    Node end = null;
    Integer capacity = 0;
    Integer count = 0;
    Map<Integer, Node> map = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            toHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // System.out.println(key);
        if (map.containsKey(key)) {
            map.get(key).value = value;
            toHead(map.get(key));
        }
        else {
            Node nn = new Node();
            nn.key = key;
            nn.value = value;
            if (count == 0) {
                end = nn;
                head = nn;
            }
            else {
                head.prev = nn;
                nn.next = head;
                head = nn;
            }
            map.put(key, nn);
            count++;
            if (capacity < count) {
                map.remove(end.key);
                end = end.prev;
                end.next = null;
                count--;
            }
        }
    }

    public void toHead(Node node) {
        if (head == node) {
            return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == end && count > 1) {
            end = node.prev;
        }
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */