package baek.step.stackQueDeq;


//Not complete since the size is fixed!!

public class ArrayStack {
    int top;    //index
    int size;    //array size
    int [] stack;


    public ArrayStack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void arrayStackPush(int item) {
        stack[++top] = item;
        System.out.println(stack[top] + " Push");
    }
    public void arrayStackPop() {
        System.out.println(stack[top] + " Pop");
        stack[top--] = 0;
    }
    public void arrayStackPeek() {
        System.out.println(stack[top] + " Peek");
    }

    public void showArrayStack() {
        for (int i : stack) {
            System.out.print(i + " ");
        }
    }
}