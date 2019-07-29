package dataStructures;

public class Stack {

    private int maxSize;
    private int[] stackArr;
    private int top;

    public Stack(int maxSize) {
        stackArr = new int[maxSize];
        top = -1;
    }

    public void push(int val) {
        stackArr[++top] = val;
    }

    public int pop() {
        return stackArr[top--];
    }

    public int peek() {
        return stackArr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }


}
