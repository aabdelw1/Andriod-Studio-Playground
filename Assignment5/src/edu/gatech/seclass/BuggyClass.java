package edu.gatech.seclass;

/**
 * This is a Georgia Tech provided code example for use in assigned
 * private GT repositories. Students and other users of this template
 * code are advised not to share it with other students or to make it
 * available on publicly viewable websites including repositories such
 * as Github and Gitlab.  Such sharing may be investigated as a GT
 * honor code violation. Created for CS6300.
 *
 * Template provided for the White-Box Testing Assignment. Follow the
 * assignment directions to either implement or provide comments for
 * the appropriate methods.
 */

public class BuggyClass {

    public static void exampleMethod1(int a) {
        // ...
        int x = a / 0; // Example of instruction that makes the method
                       // fail with an ArithmeticException
        // ...
    }

    public static int exampleMethod2(int a, int b) {
        // ...
        return (a + b) / 0; // Example of instruction that makes the
                            // method fail with an ArithmeticException
    }

    public static void exampleMethod3() {
        // NOT POSSIBLE: This method cannot be implemented because
        // <REPLACE WITH REASON> (this is the example format for a
        // method that is not possible) ***/
    }

    public static void buggyMethod1() { // Change the signature as needed
        // Either add a comment in the format provided above or
        // implement the method.
    }

    public static void buggyMethod2() { // Change the signature as needed
        // Either add a comment in the format provided above or
        // implement the method.
    }

    public static void buggyMethod3() { // Change the signature as needed
        // Either add a comment in the format provided above or
        // implement the method.
    }

    public static void buggyMethod4() { // Change the signature as needed
        // Either add a comment in the format provided above or
        // implement the method.
    }

    public static String[] buggyMethod5() {
        String a[] = new String[7];
        /*
        public static boolean providedBuggyMethod (boolean a, boolean b) {
            int x = 2;
            int y = 4;
            if(a)
                x = y * x;
            else
                x = 2*x;
            if(b)
                y -= x;
            else
                y -= 4;
            return ((x/y)>= 0);
        }
        */
        //
        // Replace the "?" in column "output" with "T", "F", or "E":
        //
        //         | a | b |output|
        //         ================
        a[0] =  /* | T | T | <T, F, or E> (e.g., "T") */ "?";
        a[1] =  /* | T | F | <T, F, or E> (e.g., "T") */ "?";
        a[2] =  /* | F | T | <T, F, or E> (e.g., "T") */ "?";
        a[3] =  /* | F | F | <T, F, or E> (e.g., "T") */ "?";
        // ================
        //
        // Replace the "?" in the following sentences with "NEVER",
        // "SOMETIMES" or "ALWAYS":
        //
        a[4] = /* Test suites with 100% statement coverage */ "?";
               /*reveal the fault in this method.*/
        a[5] = /* Test suites with 100% branch coverage */ "?";
               /*reveal the fault in this method.*/
        a[6] =  /* Test suites with 100% path coverage */ "?";
                /*reveal the fault in this method.*/
        // ================
        return a;
    }
}
