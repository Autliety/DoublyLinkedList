package mylist;

public class List {

    private Node head;
    private Node tail;
    private int size;

    public List() {
        head = new Node();
        tail = new Node(head, null, null);
        head.setNext(tail);
        size = 0;
    }

    public int getSize() { return size; }

    Node getHead() { return head; }

    Node getTail() { return tail; }

    void sizeRise() { size++; }

    void sizeDown() { size--; }

}

class Node {

    private Data data;
    private Node prev;
    private Node next;

    Node() {
        this.prev = null;
        this.data = null;
        this.next = null;
    }

    Node(Node prev, Data data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    Data getData() { return data; }

    void setData(Data data) { this.data = data; }

    Node getPrev() { return prev; }

    void setPrev(Node prev) { this.prev = prev; }

    Node getNext() { return next; }

    void setNext(Node next) { this.next = next; }

}

