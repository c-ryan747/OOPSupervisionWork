package uk.ac.cam.cpr41.oopsupervisions.supervision2.q3;

public interface StackInterface <T> {
    T pop();
    T peek();
    void push(T item);

    boolean isEmpty();
}
