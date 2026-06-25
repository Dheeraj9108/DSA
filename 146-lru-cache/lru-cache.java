class Node {
    int val;
    Node prev;
    Node next;
    int key;

    Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    int cap;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    public LRUCache(int cap) {
        this.cap = cap;
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node){
        Node prev = head.next;
        head.next = node;
        node.prev = head;

        node.next = prev;
        prev.prev = node;
    }

    public int get(int key) {
        // System.out.println(map);
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val; 
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
            return;
        } 

        if(map.size() == cap){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        Node node = new Node(key,value);
        map.put(key,node);
        insert(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */