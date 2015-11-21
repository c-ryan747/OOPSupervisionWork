package uk.ac.cam.cpr41.oopsupervisions.supervision1;

// 2c sub-class example
public class Lorry extends Vehicle {
    // Add some more state - again could make final
    private boolean hasTailLift;

    // Add some more behaviour
    public boolean isHasTailLift() {
        return hasTailLift;
    }

    public void setHasTailLift(boolean hasTailLift) {
        this.hasTailLift = hasTailLift;
    }
}
