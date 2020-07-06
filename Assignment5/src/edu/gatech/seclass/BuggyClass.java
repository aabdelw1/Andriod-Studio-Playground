package edu.gatech.seclass;

import javax.sound.midi.SysexMessage;

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

    public static void buggyMethod1() {

        // NOT POSSIBLE: This method cannot be implemented because
        // the second condition stating,  "to create a test suite that achieves 100% branch coverage 
        // and does not reveal the fault" is an impossible expression. Branch coverage is more 
        // extensive than statement coverage. That being said, if a testing suite can acheive 100% 
        // statement coverage, then it will also acheive 100% branch coverage 
    }

    public static void buggyMethod2() { 

        // NOT POSSIBLE: This method cannot be implemented because
        // Similarly to the first buggyMethod, the second condition has a flaw such that an implied else statement
        // would be missed by statement coverage where it would be covered by branch.
        // So since branch is more extensive than statement coverage, if 100% branch coverage missed the fault
        // then it is liekely that 100% statement coverage will miss it as well.

    }

    public static String buggyMethod3(int a, int b) { 
        int sum = a + b;
        String color = "";
        if(sum > 0){
            color = "red";
        } else if (sum < 0){
            color = "blue";
        } else {}
        
        return color;

    }

    public static int buggyMethod4(int a, boolean c1, boolean c2, boolean c3) { 
        int x = a;
        int y = 0;

        if(c1 == true){
            x = x + 1;
        }
        if(c2 == true){
            x = x - 1;
        }
        if(c3 == true){
            y = x;
        }
    
        return x/y;
    }

    public static String[] buggyMethod5() {
        String a[] = new String[7];
        
        //  public static boolean providedBuggyMethod (boolean a, boolean b) {
        //     int x = 2;
        //     int y = 4;
        //     if(a)
        //         x = y * x;
        //     else
        //         x = 2*x;
        //     if(b)
        //         y -= x;
        //     else
        //         y -= 4;
        //     return ((x/y)>= 0)
        // }
        
        //
        // Replace the "?" in column "output" with "T", "F", or "E":
        //
        //         | a | b |output|
        //         ================
        a[0] =  /* | T | T | <T, F, or E> (e.g., "T") */ "F";
        a[1] =  /* | T | F | <T, F, or E> (e.g., "T") */ "E";
        a[2] =  /* | F | T | <T, F, or E> (e.g., "T") */ "E";
        a[3] =  /* | F | F | <T, F, or E> (e.g., "T") */ "E";
        // ================
        //
        // Replace the "?" in the following sentences with "NEVER",
        // "SOMETIMES" or "ALWAYS":
        //
        a[4] = /* Test suites with 100% statement coverage */ "ALWAYS";
               /*reveal the fault in this method.*/
        a[5] = /* Test suites with 100% branch coverage */ "ALWAYS";
               /*reveal the fault in this method.*/
        a[6] =  /* Test suites with 100% path coverage */ "ALWAYS";
                /*reveal the fault in this method.*/
        // ================
        return a;
    }
}
