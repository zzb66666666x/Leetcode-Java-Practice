import java.util.HashMap;
// import java.util.LinkedList;

class Item{
    public Item(int key, int value){
        k = key;
        v = value;
    }
    public int k;
    public int v;
}

class DlinkedNode{
    public DlinkedNode next;
    public DlinkedNode prev;
    public Item item;
    public DlinkedNode(){
        next = null;
        prev = null;
        item = null;
    }
}

class LRUCache {
    private int capacity;
    private int count;
    HashMap<Integer, DlinkedNode> m = null;
    // LinkedList<Item> l = null;
    DlinkedNode head;
    DlinkedNode tail;

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        m = new HashMap<Integer, DlinkedNode>();
        // l = new LinkedList<Item>();
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DlinkedNode res = m.get(key);
        if (res == null)
            return -1;
        int ans = res.item.v;
        removeNode(res);
        addFirst(res);
        return ans;
    }
    
    public void put(int key, int value) {
        // already in the map
        DlinkedNode res = m.get(key);
        if (res != null){
            res.item.v = value;
            // move to the head of linkedlist
            removeNode(res);
            addFirst(res);
            return;
        }
        // not in the map
        if (count >= capacity){
            // remove the last one
            int oldK = getLast().item.k;
            m.remove(oldK);
            removeLast();
            count --;
        }   
        Item newItem = new Item(key, value);
        DlinkedNode newNode = new DlinkedNode();
        newNode.item = newItem;
        addFirst(newNode);
        m.put(key, newNode);
        count ++;
    }

    private void addFirst(DlinkedNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DlinkedNode node){
        if (node == head || node == tail)
            return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeLast(){
        removeNode(tail.prev);
    }

    private DlinkedNode getLast(){
        if (tail.prev == head)
            return null;
        return tail.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */