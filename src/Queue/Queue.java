package Queue;

public class Queue {

    private int en;
    private int de;
    private int size;
    private int length;
    private int[] arr;

    public Queue(int size){
        this.size = size;
        this.arr = new int[size];
        this.length = 0;
        this.de = 0;
        this.en = 0;
    }

    public void enQueue(int element){
        if (isFull())
            System.out.println("Queue is full!");
        else {
            arr[en] = element;
            length++;
            System.out.println("EnQueue element: " + element);
            if (en == size -1)
                en = 0;
            else
                en++;

        }
    }

    public int deQueue(){
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        else{
            int element = arr[de];
            length--;
            System.out.println("Dequeue element: " + element);
            if (de == size -1)
                de = 0;
            else
                de++;
            return element;
        }

    }

    private boolean isFull(){
        return size == length;
    }

    private boolean isEmpty(){
        return length == 0;
    }
}
