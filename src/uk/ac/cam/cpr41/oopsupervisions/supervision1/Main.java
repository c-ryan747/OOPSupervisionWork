package uk.ac.cam.cpr41.oopsupervisions.supervision1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        primitives(); // 2a
        references(); // 2b
        // 2c is shown in Lorry and Vehicle
        objects(); // 2d

        // Tests for later questions
        System.out.println(tests());
    }

    public static void primitives() {
        // 2a example of primitives
        byte    myByte    = 1;    // 8  bit signed
        short   myShort   = 1;    // 16 bit signed
        int     myInt     = 1;    // 32 bit signed
        long    myLong    = 1;    // 64 bit signed

        float   myFloat   = 1.0f; // 32 bit floating point
        double myDouble = 1.0;  // 64 bit floating point

        boolean myBoolean = true; // true or false

        char    myChar    = 'A';  // 16 bit unicode character
    }

    public static void references() {
        // 2b example of references
        int [] refToArray = new int[]{1,2,3,4,5};
        int [] alsoARefToThatArray = refToArray;

        refToArray[0]++;
        alsoARefToThatArray[2] = 10;

        // Will print out [2, 2, 10, 4, 5] twice
        System.out.println("Array via refToArray:          " + Arrays.toString(refToArray));
        System.out.println("Array via alsoARefToThatArray: " + Arrays.toString(alsoARefToThatArray));
    }

    public static void objects() {
        // 2d example of Objects
        // create a new object of class Lorry that inherits from Vehicle
        Lorry myLorry = new Lorry();

        // set an instance variables value
        myLorry.setHasTailLift(true);

        // set an inherited instance variable
        myLorry.setNumberOfWheels(8);
        myLorry.setManufacturer("Ford");

        // call an inherited method
        System.out.println(myLorry.getManufacturer());
    }

    public static int sum(int[] a) {
        int total = 0;
        for (int element: a) {
            total += element;
        }
        return total;
    }

    public static int[] cumsum(int[] a) {
        int[] cumlativeSum = new int[a.length];
        int total = 0;

        for (int i = 0; i < a.length; i++) {
            total += a[i];
            cumlativeSum[i] = total;
        }

        return cumlativeSum;
    }

    public static int[] positives(int[] a) {
        int numberOfPositives = 0;
        for (int element: a) {
            if (element > 0) {
                numberOfPositives++;
            }
        }

        int[] positiveInts = new int[numberOfPositives];
        int index = 0;
        for (int element: a) {
            if (element > 0) {
                positiveInts[index] = element;
                index++;
            }
        }

        return positiveInts;
    }

    public static float[][] blankMatrix(int n) {
        return new float[n][n];
    }

    public static String tests() {
        String results = "Failed tests:\n";

        if (sum(new int[]{}) != 0) results += "Failed sum(new int[] {})\n";
        if (sum(new int[]{1}) != 1) results += "Failed sum(new int[] {1})\n";
        if (sum(new int[]{1, 2, 3, 4}) != 10) results += "Failed sum(new int[] {1,2,3,4})\n";

        if (!Arrays.equals(cumsum(new int[]{}), new int[]{})) results += "Failed cumsum(new int[] {}\n)";
        if (!Arrays.equals(cumsum(new int[]{1}), new int[]{1})) results += "Failed cumsum(new int[] {1})\n";
        if (!Arrays.equals(cumsum(new int[]{1, 2, 3, 4}), new int[]{1, 3, 6, 10}))
            results += "Failed cumsum(new int[] {1,2,3,4})\n";

        if (!Arrays.equals(positives(new int[]{}), new int[0])) results += "Failed positives(new int[] {})\n";
        if (!Arrays.equals(positives(new int[]{1}), new int[]{1})) results += "Failed positives(new int[] {1})\n";
        if (!Arrays.equals(positives(new int[]{1, -2, 3, -4}), new int[]{1, 3}))
            results += "Failed positives(new int[] {1,2,3,4})\n";

        Vector2D vectorA = new Vector2D(1, 2);
        vectorA.vectorAdd(2, 3);
        Vector2D vectorB = new Vector2D(3, 5);
        if (!vectorA.equals(vectorB)) results += "Failed vectorA.equals(vectorB)\n";

        try {
            LinkedList ll1 = new LinkedList(new LLElement(1));
            LLElement element = new LLElement(1);
            element.setNext(new LLElement(2));
            LinkedList ll2 = new LinkedList(element);
            ll1.addValue(new LLElement(2), 1);

            if (!ll1.equals(ll2)) results += "Failed LinkedList.equivlent(ll1, ll2)\n";

            if (ll1.getElementAtIndex(1).getValue() != 2) results += "Failed ll2.getElementAtIndex(1)\n";
            if (ll1.getElementAtIndex(0).getValue() != 1) results += "Failed ll2.getElementAtIndex(0)\n";

            ll1.removeValue(0);
            if (!ll1.equals(new LinkedList(new LLElement(2))))
                results += "Failed ll1.equals(new LinkedList(new LLElement(2)))\n";


            if (ll2.getLength() != 2) results += "Failed ll2.getLength()\n";

            if (ll2.listContainsACycle()) results += "Failed LinkedList.listContainsACycle(ll2)\n";
            LLElement element1 = new LLElement(1);
            LLElement element2 = new LLElement(2);
            element1.setNext(element2);
            element2.setNext(element1);
            LinkedList ll3 = new LinkedList(element1);
            if (!ll3.listContainsACycle()) results += "Failed !LinkedList.listContainsACycle(ll3)\n";

        } catch (LLIndexOutOfBounds e) {
            results += "Failed: LLIndexOutOfBounds raised:" + e.getMessage() + "\n";
        }

        Stack sA = new Stack(3);
        try {
            sA.push(1);
            sA.push(2);
            sA.push(3);
            try {
                sA.push(4);
                results += "Failed sA.push(4)";
            } catch (StackException e) {/* Passed */}
            int[] sAasArray = new int[3];
            for (int i = 0; i < 3; i++) {
                sAasArray[2 - i] = sA.pop();
            }
            try {
                sA.pop();
                results += "Failed sA.pop()";
            } catch (StackException e) {/* Passed */}

            if (!Arrays.equals(sAasArray, new int[]{1, 2, 3}))
                results += "Failed Arrays.equals(sAasArray, new int[]{3,2,1})\n";

        } catch (StackException e) {
            results += "Failed: StackException raised:" + e.getMessage() + "\n";
        }
        if (results.equals("Failed tests:\n")) results = "All tests passed";
        return results;
    }

}
