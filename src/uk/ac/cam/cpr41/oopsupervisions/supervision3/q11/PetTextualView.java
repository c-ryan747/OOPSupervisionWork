package uk.ac.cam.cpr41.oopsupervisions.supervision3.q11;

public class PetTextualView extends PetViewInterface {

    @Override
    public void outputState() {
        int i = 0;
        for (Pet p : data) {
            System.out.println(i + "\t" + p.name() + "\t Sleep: " + p.getCurrentSleep() + "\t Food: " + p.getCurrentFood() + "\t Alive: " + (p.getAlive() ? ":)" : ":("));
            i++;
        }
        System.out.println();
    }

    @Override
    public void displayMessge(String s) {
        System.out.println(s);
    }

    @Override
    public void showOptions() {
        System.out.println("Options;");
        System.out.println("1 x to feed pet x");
        System.out.println("2 x to make pet x sleep");
        System.out.println("3 x to play with pet x");
        System.out.println("4 x to discard pet x");
        System.out.println("5 x to create a new pet of type x (1:Dog, 2:Ninja, 3:Fish)");
        System.out.println("quit to quit");
        System.out.println();
    }

    public PetTextualView(PetDataStore pds) {
        data = pds;
    }
}
