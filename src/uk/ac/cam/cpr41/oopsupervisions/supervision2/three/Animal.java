package uk.ac.cam.cpr41.oopsupervisions.supervision2.three;

public abstract class Animal {
    int xPos, yPos;

    public void move(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    abstract public void makeNoise();
}
