
import java.util.HashMap;
import java.util.Map;

class LRUCache {

    // Node of the doubly linked list
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        // Constructor
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;
    private final int capacity;

    // Constructor: initialize cache and dummy nodes
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy head and tail simplify insertion and deletion
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Get value by key; return -1 if key does not exist
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Mark this node as recently used
        removeNode(node);
        addAfterHead(node);

        return node.value;
    }

    // Insert or update a key-value pair
    public void put(int key, int value) {

        // If key already exists, update its value
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            // Move updated node to the most recently used position
            removeNode(node);
            addAfterHead(node);
            return;
        }

        // Create and insert a new node
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addAfterHead(newNode);

        // Remove the least recently used node if capacity is exceeded
        if (map.size() > capacity) {
            Node lruNode = tail.prev;

            removeNode(lruNode);
            map.remove(lruNode.key);
        }
    }

    // Remove a node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node immediately after the dummy head
    private void addAfterHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}
