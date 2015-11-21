package uk.ac.cam.cpr41.oopsupervisions.supervision2.three;

public interface StackInterface <T> {
    public T pop();
    public T peek();
    public void push(T item);

    public boolean isEmpty();
}
