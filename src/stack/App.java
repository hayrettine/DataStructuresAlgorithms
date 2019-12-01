package stack;

import LinkedList.MyLinkedList;
import Queue.Queue;
import Queue.QueueLinkedList;
import LinkedList.DoublyLinkedList;

public class App {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.pop();
        stack.push(12);
        stack.push(2);
        stack.push(-112);
        stack.push(47);
        stack.pop();
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        stack.pop();
        stack.push(11);
        stack.pop();
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        stack.push(16);
        System.out.println("Sorted:");
        stack.sortStack();


        System.out.println("==================================================");
        StackLinkedList stackLinkedList = new StackLinkedList();

        stackLinkedList.push(12);
        stackLinkedList.push(22);
        stackLinkedList.push(-1);
        stackLinkedList.push(-309);
        stackLinkedList.pop();
        stackLinkedList.pop();
        stackLinkedList.push(-1);

        System.out.println("==================================================");

        Queue queue = new Queue(3);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(5);
        queue.enQueue(6);
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        System.out.println("==================================================");

        QueueLinkedList queueLinkedList = new QueueLinkedList();

        queueLinkedList.enQueue(1);
        queueLinkedList.enQueue(2);
        queueLinkedList.enQueue(3);
        queueLinkedList.enQueue(4);
        queueLinkedList.deQueue();
        queueLinkedList.deQueue();
        queueLinkedList.enQueue(5);
        queueLinkedList.enQueue(6);
        queueLinkedList.deQueue();
        queueLinkedList.deQueue();

        System.out.println("==================================================");

        MyLinkedList list = new MyLinkedList();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertLast(5);
        list.printList();
        list.deleteFirst();
        list.printList();
        list.deleteAfter(2);
        list.printList();
        list.insertLast(-12);
        list.printList();
        list.insertFirst(23);
        list.printList();
        list.reverse();
        list.printList();
        list.findMid();
        System.out.println(list.getFromLast(2));
        System.out.println(list.isCyclic());
        list.doCycle();
        System.out.println(list.isCyclic());
        System.out.println(list.findStart());

        MyLinkedList linkedList = new MyLinkedList();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(11);
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);
        linkedList.findMid();
        linkedList.printList();
        MyLinkedList list1 = new MyLinkedList();
        list1.insertFirst(1);
        list1.insertFirst(2);
        list1.insertFirst(3);
        list1.insertFirst(4);
        list1.insertLast(5);
        System.out.println(linkedList.isPalindrom());
        linkedList.printList();
        list1.insertLast(linkedList.getFromLastNode(3));
        list1.printList();
        linkedList.intersection(list1);
        list1.reversePair();
        list1.printList();

        System.out.println("==================================================");

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.print();

    }
}
