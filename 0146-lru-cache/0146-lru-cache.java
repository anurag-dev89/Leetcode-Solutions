class LRUCache {

    // Each node stores one key-value pair
    class Node {
        int key;
        int value;

        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;

    // HashMap helps us find any node in O(1)
    HashMap<Integer, Node> map = new HashMap<>();

    // Dummy nodes (they never store real data)
    Node head = new Node(0, 0);   // Most recent side
    Node tail = new Node(0, 0);   // Least recent side

    public LRUCache(int capacity) {
        this.capacity = capacity;

        // Empty list : HEAD <-> TAIL
        head.next = tail;
        tail.prev = head;
    }

    // Put a node right after HEAD
    // This makes it the most recently used node
    private void add(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Remove a node from the linked list
    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {

        // Key not found
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        // Since we used it, move it to the front
        remove(node);
        add(node);

        return node.value;
    }

    public void put(int key, int value) {

        // If key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            // Update value
            node.value = value;

            // Move it to the front (recently used)
            remove(node);
            add(node);

            return;
        }

        // Cache is full
        if (map.size() == capacity) {

            // Last real node = Least Recently Used
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        // Create new node
        Node newNode = new Node(key, value);

        // Store in both HashMap and Linked List
        map.put(key, newNode);
        add(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */