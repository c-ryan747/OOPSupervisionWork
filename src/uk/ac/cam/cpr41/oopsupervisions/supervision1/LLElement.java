package uk.ac.cam.cpr41.oopsupervisions.supervision1;

public class LLElement {
    private int value;
    private LLElement next;

    public LLElement(int x) {
        this.value = x;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LLElement getNext() {
        return next;
    }

    public void setNext(LLElement next) {
        this.next = next;
    }
}
