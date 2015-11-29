package uk.ac.cam.cpr41.oopsupervisions.supervision3.q7;

import java.util.LinkedList;
import java.util.Queue;

public class PrintQueue<T> {
    private Queue<T> queue = new LinkedList<T>();

    private static volatile PrintQueue instance;
    private PrintQueue() { }

    public static synchronized PrintQueue getInstance() {
        // Thread safe due to synchronized?
        if (instance == null) {
            instance = new PrintQueue();
        }

        return instance;
    }

    public void addItem(T s) {
        queue.offer(s);
    }

    public T getNext() {
        return queue.poll();
    }
}
