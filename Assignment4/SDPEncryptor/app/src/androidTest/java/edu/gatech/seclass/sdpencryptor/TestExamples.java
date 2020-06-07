package edu.gatech.seclass.sdpencryptor;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * This is a Georgia Tech provided code example for use in assigned private GT repositories. Students and other users of this template
 * code are advised not to share it with other students or to make it available on publicly viewable websites including
 * repositories such as github and gitlab.  Such sharing may be investigated as a GT honor code violation. Created for CS6300.
 */


@RunWith(AndroidJUnit4.class)
public class TestExamples {

    @Rule
    public ActivityTestRule<MainActivity> tActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void Screenshot1() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("Cat & Dog"));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("3"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("2"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.encryptedMessageID)).check(matches(withText("fFA & mZT")));
    }

    @Test
    public void Screenshot2() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("Up with the White And Gold!"));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("1"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.encryptedMessageID)).check(matches(withText("vR ZMYN APN gSUGS pDU yHFY!")));
    }

    @Test
    public void Screenshot3() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("abcdefg"));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("2"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.encryptedMessageID)).check(matches(withText("CEGIKMO")));
    }

    @Test
    public void Screenshot4() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("XYZabcABCxyz"));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("22"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("19"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.encryptedMessageID)).check(matches(withText("tnhBVPgauICW")));
    }

    @Test
    public void ScreenshotErrors1() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("12345"));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("2"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("4"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.messageID)).check(matches(hasErrorText("Invalid Message")));
    }

    @Test
    public void ScreenshotErrors2a() {
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("30"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.keyNumberID)).check(matches(hasErrorText("Invalid Key Number")));
    }

    @Test
    public void ScreenshotErrors2b() {
        onView(withId(R.id.messageID)).perform(clearText());
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("30"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.messageID)).check(matches(hasErrorText("Invalid Message")));
    }

    @Test
    public void ScreenshotErrors2c() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText(""));;
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("0"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("30"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.incrementNumberID)).check(matches(hasErrorText("Invalid Increment Number")));
    }

    @Test
    public void ScreenshotErrors3a() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("123"));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("35"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("88"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.incrementNumberID)).check(matches(hasErrorText("Invalid Increment Number")));
    }

    @Test
    public void ScreenshotErrors3b() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("123"));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("35"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("88"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.messageID)).check(matches(hasErrorText("Invalid Message")));
    }

    @Test
    public void ScreenshotErrors3c() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("123"));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("35"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("88"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.keyNumberID)).check(matches(hasErrorText("Invalid Key Number")));
    }

    @Test
    public void ScreenshotLabel() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("Test Example!!."));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("20"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("2"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.encryptedMessageID)).check(matches(withText("nAQT gBGUZXS!!.")));
    }

    @Test
    public void ExtraTest1() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("Panda eats shoots and leaves."));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("5"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("5"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.encryptedMessageID)).check(matches(withText("uKCXZ IJHL QKWBLP CUP CABBPI.")));
    }

    @Test
    public void ExtraTest2() {
        onView(withId(R.id.messageID)).perform(clearText(), replaceText("aaaaaa"));
        onView(withId(R.id.keyNumberID)).perform(clearText(), replaceText("1"));
        onView(withId(R.id.incrementNumberID)).perform(clearText(), replaceText("1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.encryptButtonID)).perform(click());
        onView(withId(R.id.encryptedMessageID)).check(matches(withText("BCDEFG")));
    }

}
