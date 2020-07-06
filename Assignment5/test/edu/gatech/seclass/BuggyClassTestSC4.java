package edu.gatech.seclass;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a Georgia Tech provided code example for use in assigned
 * private GT repositories. Students and other users of this template
 * code are advised not to share it with other students or to make it
 * available on publicly viewable websites including repositories such
 * as Github and Gitlab.  Such sharing may be investigated as a GT
 * honor code violation. Created for CS6300.
 *
 * Junit test class provided for the White-Box Testing Assignment.
 * This class should not be altered.  Follow the directions to create
 * similar test classes when required.
 */

public class BuggyClassTestSC4 {

    @Test
    public void Test1() {
        BuggyClass.buggyMethod4(1, true, true, true);
    }

    @Test
    public void Test2() {
        BuggyClass.buggyMethod4(1, false, false, false);
    }
}
