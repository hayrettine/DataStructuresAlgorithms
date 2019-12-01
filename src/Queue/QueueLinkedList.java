package Queue;

public class QueueLinkedList {
    Node head;

    private class Node{
        int value;
        Node next;
    }

    public QueueLinkedList(){
        this.head = null;
    }

    public void enQueue(int element){
        Node oldHead = head;
        head = new Node();
        head.value = element;
        head.next = oldHead;
        System.out.println("Queue element: " + element);
    }

    public int deQueue(){
        if (head != null){
            Node en = head;
            Node de = en.next;
            while(hasNext(de)) {
                en = en.next;
                de = de.next;
            }
            int element = de.value;
            en.next = null;
            System.out.println("Dequeue element: " + element);
            return element;
        }else{
            System.out.println("Queue is empty!");
            return -1;
        }

    }

    private boolean hasNext(Node de){
        return de.next != null;
    }
}
