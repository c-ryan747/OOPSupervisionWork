package uk.ac.cam.cpr41.oopsupervisions.supervision2.four;

import uk.ac.cam.cpr41.oopsupervisions.supervision2.three.Dog;

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
