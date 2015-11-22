package uk.ac.cam.cpr41.oopsupervisions.supervision2.q4;

import uk.ac.cam.cpr41.oopsupervisions.supervision2.q3.Dog;

public class GermanShepherd extends Dog {
    @Override
    public void makeNoise() {
        System.out.println("Grrrrr");
    }

    public static void main(String[] args) {
        GermanShepherd a = new GermanShepherd();
        Dog b = a;
        //Will Print out "Grrrrr" due to dynamic polymorphism
        b.makeNoise();
    }
}
