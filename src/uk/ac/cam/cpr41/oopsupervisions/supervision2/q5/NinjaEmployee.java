package uk.ac.cam.cpr41.oopsupervisions.supervision2.q5;

public class NinjaEmployee  extends Employee implements NinjaInterface {
    private final Ninja ninja = new Ninja();

    @Override
    public void hide() {
        ninja.hide();
    }
}
