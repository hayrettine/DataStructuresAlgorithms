package LinkedList;

public class MyLinkedList {

    private Node head;

    private class Node{

        private int value;
        private Node next;

        public void displayNode(){
            System.out.println("{" + value + "}");
        }

    }

    public MyLinkedList(){
        this.head = null;
    }

    public boolean isEmpty(){return head == null;}

    public void insertFirst(int element){
        Node newNode = new Node();
        newNode.value = element;
        newNode.next = head;
        head = newNode;
    }
    public void doCycle(){
        this.head.next.next.next = this.head.next;
    }

    public Node deleteFirst(){
        Node temp = head;
        head = head.next;
        temp.displayNode();
        return temp;
    }

    public Node deleteAfter(int val){
        Node temp = head;
        while(temp.next != null && temp.value != val)
            temp = temp.next;
        if (temp.next != null) {
            temp.next.displayNode();
            temp.next = temp.next.next;
            return temp.next;
        }else
            return new Node();
    }

    public void insertLast(int element){
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        Node node = new Node();
        node.value = element;
        temp.next = node;
    }
    public void insertLast(Node element){
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = element;
    }

    public void printList(){
        Node temp = head;
        System.out.print("[");
        while (temp.next != null){
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
        System.out.print(temp.value);
        System.out.println("]");

    }

    public Node reverse(){
        Node currentNode = this.head;
        Node nextNode;
        Node previousNode = null;
        while (currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        this.head = previousNode;
        return previousNode;
    }

    public Node findMid(){
        Node fast, slow;
        fast = slow = this.head;
        while(fast != null){
            fast = fast.next;
            if (fast != null && fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        slow.displayNode();
        return slow;
    }

    public int getFromLast(int n){
        Node first, second;
        first = second = this.head;
        for (int i = 0; i < n; i++)
            first = first.next;
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second.value;
    }

    public Node getFromLastNode(int n){
        Node first, second;
        first = second = this.head;
        for (int i = 0; i < n; i++)
            first = first.next;
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }


    public boolean isCyclic(){
        Node fastPointer, slowPointer;
        fastPointer = slowPointer = this.head;
        while(fastPointer != null){
            fastPointer = fastPointer.next;
            if (fastPointer != null && fastPointer.next != null){
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
            if (fastPointer == slowPointer)
                return true;
        }
        return false;
    }

    public int findStart(){
        Node fst, slw;
        fst = slw = this.head;
        boolean cycle = false;
        while(fst != null && fst.next != null){
            fst = fst.next.next;
            slw = slw.next;
            if (fst == slw) {
                cycle = true;
                break;
            }
        }
        if (cycle){
            slw = this.head;
            while(slw != fst){
                slw = slw.next;
                fst = fst.next;
            }
            return slw.value;
        }else
            return -1;
    }

    public Node get(int n){
        Node temp = this.head;
        for (int i = 0; i < n; i++)
            temp = temp.next;
        return temp;
    }

    public boolean isPalindrom(){
        Node firstNode = this.head;
        Node midNode = findMid();
        MyLinkedList list = new MyLinkedList();
        list.head = midNode;
        list.reverse();
        Node reverseMid = list.head;
        while(reverseMid != null && firstNode != null){
            if (reverseMid.value != firstNode.value)
                return false;
            else{
                firstNode = firstNode.next;
                reverseMid = reverseMid.next;
            }
        }
        return true;
    }

    public Node intersection(MyLinkedList list){
        Node firstPtr = this.head;
        Node scndPtr = list.head;
        int difference1 = length(this);
        int difference2 = length(list);
        if (difference1 > difference2){
            int diff = difference1 - difference2;
            for (int i = 0; i < diff; i++)
                firstPtr = firstPtr.next;
        }else{
            int diff = difference2 - difference1;
            for (int i = 0; i < diff; i++)
                scndPtr = scndPtr.next;
        }
        while(scndPtr != null && firstPtr != null){
            if (scndPtr == firstPtr) {
                scndPtr.displayNode();
                return scndPtr;
            }
            firstPtr = firstPtr.next;
            scndPtr = scndPtr.next;
        }
        return null;
    }

    public void reversePair(){
        Node temp = null;
        Node current = this.head;
        Node newHead = null;
        while(current != null && current.next != null){

            if (temp != null)
                temp.next.next = current.next;

            temp = current.next;
            current.next = temp.next;
            temp.next = current;

            if (newHead == null) {
                newHead = temp;
                this.head = newHead;
            }
            current = current.next;
        }
    }

    private int length(MyLinkedList list){
        Node temp = list.head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

}