package uk.ac.cam.cpr41.oopsupervisions.supervision2.five;

public class NinjaEmployee  extends Employee implements NinjaInterface {
    private final Ninja ninja = new Ninja();

    @Override
    public void hide() {
        ninja.hide();
    }
}
