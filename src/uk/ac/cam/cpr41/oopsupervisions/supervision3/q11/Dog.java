package uk.ac.cam.cpr41.oopsupervisions.supervision3.q11;

public class Dog extends Pet {

    private static int foodDecreaseRate  = -2;
    private static int sleepDecreaseRate = -2;

    @Override
    public int foodDecreaseRate() {
        return foodDecreaseRate;
    }

    @Override
    public int sleepDecreaseRate() {
        return sleepDecreaseRate;
    }

    @Override
    public String name() {
        return "Dog";
    }
}
