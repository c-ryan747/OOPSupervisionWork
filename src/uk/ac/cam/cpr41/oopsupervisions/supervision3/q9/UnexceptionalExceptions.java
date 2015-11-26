package uk.ac.cam.cpr41.oopsupervisions.supervision3.q9;

public class UnexceptionalExceptions {

    public static void main (String args[]) {
        int[] myArray = {1,2,3,4,5};

        // Bad way
        int sum1 = 0;
        try {
            int i = 0;
            while (true) {
                sum1 += myArray[i];
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // Done
        }

        // Correct way
        int sum2 = 0;
        for (int x : myArray) {
            sum2 += x;
        }


        // (sum1 == sum2) is true
        System.out.println("Are results equal? " + (sum1 == sum2));
    }
}
