package uk.ac.cam.cpr41.oopsupervisions.supervision3.q3;

/**
 * Created by callum on 26/11/15.
 */
public class StringTest {
    public static void main(String args[]) {
        String s1 = new String("Hi");
        String s2 = new String("Hi");
        System.out.println( (s1==s2) );

        String s3 = "Hi";
        String s4 = "Hi";
        System.out.println( (s3==s4) );
    }
}
