package uk.ac.cam.cpr41.oopsupervisions.supervision3.q11;

public abstract class Pet {
    private int currentFood = 10;
    private int currentSleep = 10;

    private boolean alive = true;


    public boolean getAlive() {
        return alive;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public void addFood(int difference) {
        currentFood += difference;
        if (currentFood <= 0) alive = false;
    }

    public int getCurrentSleep() {
        return currentSleep;
    }

    public void addSleep(int difference) {
        currentSleep += difference;
        if (currentSleep <= 0) alive = false;
    }

    public void play() {
        addFood(foodDecreaseRate());
        addSleep(sleepDecreaseRate());
    }

    public void feed() {
        addFood(5);
    }

    public void sleep() {
        addSleep(5);
    }

    public abstract String name();
    public abstract int foodDecreaseRate();
    public abstract int sleepDecreaseRate();
}
