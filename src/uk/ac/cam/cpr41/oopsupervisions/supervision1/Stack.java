package uk.ac.cam.cpr41.oopsupervisions.supervision1;

public class Stack {
    private final int[] stack;
    private final int size;
    private int stackPointer = 0;


    public Stack (int size) {
        // Tried to make it a generic stack with (T[]) Array.newInstance(type, size)
        // But not so sure if thats a greate idea
        this.stack = new int[size];
        this.size = size;
    }

    public boolean isStackFull () {
        return stackPointer == size;
    }

    public boolean isStackEmpty () {
        return stackPointer == 0;
    }

    public void push(int x) throws StackException {
        if (isStackFull()) {
            throw new StackException("Trying to push an element onto a full stack");
        } else {
            stack[stackPointer] = x;
            stackPointer++;
        }
    }

    public int pop () throws StackException {
        if (isStackEmpty()) {
            throw new StackException("Trying to pop an element off an empty stack");
        } else  {
            // Do i want to clear the value here?
            stackPointer = stackPointer - 1;
            return stack[stackPointer];
        }
    }

    public int peek() throws StackException {
        if (isStackEmpty()) {
            throw new StackException("Trying to peek at an empty stack");
        } else {
            return stack[stackPointer - 1];
        }
    }
}
