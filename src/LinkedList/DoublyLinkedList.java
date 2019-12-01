package LinkedList;

public class DoublyLinkedList {

    private Node head;

    class Node{
        int element;
        Node previous;
        Node next;

        public void printNode(){
            System.out.println("{" + element + "}");
        }
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public void insertFirst(int val){
        Node node = new Node();
        node.element = val;
        if (this.head != null){
            this.head.previous = node;
            node.next = head;
            this.head = node;
        }else{
            this.head = node;
        }
    }


    public void print(){
        Node current = this.head;
        System.out.print("[");
        while (current.next != null){
            System.out.print(current.element + ", ");
            current = current.next;
        }
        System.out.print(current.element);
        System.out.println("]");
    }


}
