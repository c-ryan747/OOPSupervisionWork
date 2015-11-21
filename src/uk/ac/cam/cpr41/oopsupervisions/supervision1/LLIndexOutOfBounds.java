package uk.ac.cam.cpr41.oopsupervisions.supervision1;


public class LLIndexOutOfBounds extends Exception {
    public LLIndexOutOfBounds(int index, int length) {
        super("Index, " + index + ", is out of valid range 0->" + length);
    }
}
