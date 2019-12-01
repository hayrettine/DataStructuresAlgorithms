package stack;

public class Stack {

    private int size;
    private int array[];
    private int top;

    public Stack(int size){
        this.size = size;
        this.array = new int[size];
        top = -1;
    }

    public void push(int element){
        if (top < size-1){
            top ++;
            array[top] = element;
            System.out.println("Pushed to stack: " + element);
        }else{
            System.out.println("Stack is full!!");
        }
    }

    public int pop(){
        if (top > -1) {
            int element = array[top];
            top--;
            System.out.println("Popped from stack: " + element);
            return element;
        }else{
            System.out.println("Stack has no element!!");
            return Integer.MIN_VALUE;
        }
    }

    private int peek(){
        return array[top];
    }
    private boolean isFull(){
        return top + 1 == size;
    }



    public Stack sortStack(){
        Stack tempStack = new Stack(10);
        while(this.top != -1) {
            int popped = this.pop();
            while (tempStack.top != -1 && popped < tempStack.peek())
                this.push(tempStack.pop());
            tempStack.push(popped);
        }
        for (int i = 0; i< tempStack.size; i++)
            System.out.println(tempStack.array[i]);
        return tempStack;
    }
}
