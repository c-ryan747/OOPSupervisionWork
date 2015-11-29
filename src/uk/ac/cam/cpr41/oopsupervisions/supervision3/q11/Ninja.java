package uk.ac.cam.cpr41.oopsupervisions.supervision3.q11;

public class Ninja extends Pet {

    private static int foodDecreaseRate  = -1;
    private static int sleepDecreaseRate = -1;

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
        return "Ninja";
    }
}
