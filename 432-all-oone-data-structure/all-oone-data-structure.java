
class Node {
    int fre;
    Node prev;
    Node next;
    Set<String> keys;

    Node(int fre) {
        this.fre = fre;
        keys = new HashSet<>();
    }
}

class AllOne {

    Map<String, Node> map;
    Node head;
    Node tail;

    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.keys.remove(key);

            Node nextNode = node.next;

            if (nextNode == tail || nextNode.fre != node.fre + 1) {
                Node newNode = new Node(node.fre + 1);
                newNode.keys.add(key);

                newNode.next = nextNode;
                newNode.prev = node;

                node.next = newNode;
                nextNode.prev = newNode;
                map.put(key, newNode);
            } else {
                nextNode.keys.add(key);
                map.put(key, nextNode);
            }

            if (node.keys.isEmpty()) {
                removeNode(node);
            }
        } else {
            Node nextNode = head.next;
            if (nextNode == tail || head.next.fre > 1) {
                Node newNode = new Node(1);
                newNode.keys.add(key);

                head.next = newNode;
                newNode.prev = head;

                newNode.next = nextNode;
                nextNode.prev = newNode;
                map.put(key, newNode);
            } else {
                nextNode.keys.add(key);
                map.put(key, nextNode);
            }
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }

        Node node = map.get(key);
        Node prev = node.prev;
        Node nextNode = node.next;
        node.keys.remove(key);

        if (node.fre == 1)
            map.remove(key);
        else {
            if (prev == head || prev.fre != node.fre - 1) {
                Node newNode = new Node(node.fre - 1);
                newNode.keys.add(key);
                prev.next = newNode;
                newNode.prev = prev;
                
                newNode.next = node;
                node.prev = newNode;         
                map.put(key, newNode);
            } else {
                prev.keys.add(key);
                map.put(key, prev);
            }
        }

        if (node.keys.isEmpty()) {
            removeNode(node);
        }
    }

    public String getMaxKey() {
        Node max = tail.prev;

        if (max == head)
            return "";

        return max.keys.iterator().next();
    }

    public String getMinKey() {
        Node min = head.next;

        if (min == tail)
            return "";

        return min.keys.iterator().next();
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

//  a -> 1
//  b -> 4
//  c -> 6
//  d -> 7