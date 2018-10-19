package mylist;

public class Pointer implements Cloneable {

    private Node point;
    private List list;

    public Pointer(List list) {
        this.list = list;
        toHead();
    }

    public Data getData() { return point.getData(); }

    public void setData(Data d) { point.setData(d); }

    public void shift() { point = point.getNext(); }

    public void reshi() { point = point.getPrev(); }

    public void toHead() { point = list.getHead().getNext(); }

    public void toTail() { point = list.getTail().getPrev(); }

    public boolean ifHead() { return point == list.getHead(); }

    public boolean ifTail() { return point == list.getTail(); }

    public void insert(Data data) {
        Node temp = new Node(point.getPrev(), data, point);
        point.getPrev().setNext(temp);
        point.setPrev(temp);
        list.sizeRise();
    }

    public void delete() {
        point.getNext().setPrev(point.getPrev());
        point.getPrev().setNext(point.getNext());
        list.sizeDown();
    }

    @Override
    public Pointer clone() {
        Pointer p = null;
        try {
            p = (Pointer)super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
