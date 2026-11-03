import java.util.*;
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key,int value){
        this.key=key;
        this.value=value;
        this.prev=prev;
        this.next=next;
    }
}
class LRUCache {
    private Map<Integer,Node> cacheMap;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cacheMap=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        Node node=cacheMap.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node old=cacheMap.get(key);
            remove(old);
        }
        Node node=new Node(key,value);
        cacheMap.put(key,node);
        add(node);
        if(cacheMap.size()>capacity){
            Node del=tail.prev;
            remove(del);
            cacheMap.remove(del.key);
        }
    }
    private void add(Node node) {

        // Add immediately after head
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;

        node.next = nextNode;
        nextNode.prev = node;
    }

    private void remove(Node node) {

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */