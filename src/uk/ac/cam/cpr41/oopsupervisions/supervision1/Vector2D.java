package uk.ac.cam.cpr41.oopsupervisions.supervision1;

public class Vector2D {
    private int x;
    private int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void vectorAdd(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean equals(Object obj) {
        // Check ist the right kind of class, then cast obj to Vector2D and check if equal
        if (this.getClass() == obj.getClass()) {
            Vector2D v = (Vector2D) obj;
            return (this.x == v.x && this.y == v.y);
        }
        return false;
    }
}
