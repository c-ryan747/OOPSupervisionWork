package uk.ac.cam.cpr41.oopsupervisions.supervision1;

import java.util.ArrayList;
import java.util.List;

public class StackAL <T> {
    private List<T> stack;
    private int stackPointer = 0;


    public StackAL() {
        this.stack = new ArrayList<T>();
    }

    public boolean isStackEmpty () {
        return stackPointer == 0;
    }

    public void push(T x) throws StackException {
        stack.add(stackPointer,x);
        stackPointer++;
    }

    public T pop () throws StackException {
        if (isStackEmpty()) {
            throw new StackException("Trying to pop an element off an empty stack");
        } else  {
            // Do i want to clear the value here?
            stackPointer = stackPointer - 1;
            return stack.get(stackPointer);
        }
    }

    public T peek() throws StackException {
        if (isStackEmpty()) {
            throw new StackException("Trying to peek at an empty stack");
        } else {
            return stack.get(stackPointer - 1);
        }
    }
}
