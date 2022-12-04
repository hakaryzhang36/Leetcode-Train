// Leetcode 146-lru-cache
class LRUCache {
    class Block {
        int key;
        int value;
        Block front;
        Block back;

        public Block() {};

        public Block(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Block> map = new HashMap<>();
    Block head;
    Block end;
    int capacity;
    int used;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.used = 0;
        this.head = new Block();
        this.end = new Block();
        this.head.back = end;
        this.end.front = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            // update
            Block b = map.get(key);
            // update LRU
            out(b);
            move2end(b);
            return b.value;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // 如果未溢出
        if (map.containsKey(key)) {
            // 如果已存在
            Block b = map.get(key);
            b.value = value;
            // update LRU
            out(b);
            move2end(b);
        }
        else {
            if (used == capacity) {
                // remove head
                Block o = head.back;
                map.remove(o.key);
                out(o);
                used--;
            }
            Block b = new Block(key, value);
            map.put(key, b);
            // update
            move2end(b);
            used++;
        }
    }

    private void out(Block b) {
        b.front.back = b.back;
        b.back.front = b.front;
    }

    private void move2end(Block b) {
        b.front = end.front;
        b.back = end;
        b.front.back = b;
        end.front = b;
    }
}