package uk.ac.cam.cpr41.oopsupervisions.supervision3.q11;

public abstract class PetViewInterface {
    protected PetDataStore data;

    public abstract void outputState();
    public abstract void showOptions();
    public abstract void displayMessge(String s);

}
