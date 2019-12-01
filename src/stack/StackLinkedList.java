package stack;

public class StackLinkedList {
    Node head;

    private class Node{
        int value;
        Node next;
    }

    public StackLinkedList(){
        this.head = null;
    }

    public void push(int element){
        Node oldHead = head;
        head = new Node();
        head.value = element;
        head.next = oldHead;
        System.out.println("Pushed to element: " + element);
    }

    public int pop(){
        if (head == null)
            throw new LinkedListNullException();
        else {
            int element = head.value;
            head = head.next;
            System.out.println("Popped element from stack: " + element);
            return element;
        }
    }

    class LinkedListNullException extends RuntimeException{

        public LinkedListNullException(){
            super();
        }

        public LinkedListNullException(String message){
            super(message);
        }
    }
}
