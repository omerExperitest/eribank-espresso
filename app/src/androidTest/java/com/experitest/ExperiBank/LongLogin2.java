package com.experitest.ExperiBank;


import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.core.deps.guava.base.Strings;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.experitest.ExperiBank.LoginActivity;
import com.experitest.ExperiBank.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.StringContains;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LongLogin2 {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void loginActivityTest2() {
        for(int i = 0; i < 40; i ++) {
            makePayment();
        }

    }

    private void makePayment() {
        ViewInteraction editText = onView(
                ViewMatchers.withId(R.id.usernameTextField));
        editText.perform(scrollTo(), click());

        ViewInteraction editText2 = onView(
                withId(R.id.usernameTextField));
        editText2.perform(scrollTo(), click());

        ViewInteraction editText3 = onView(
                withId(R.id.usernameTextField));
        editText3.perform(scrollTo(), replaceText("company"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                withId(R.id.passwordTextField));
        editText4.perform(scrollTo(), replaceText("compa"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withId(R.id.loginButton), withText("Login"),
                        withParent(allOf(withId(R.id.makePaymentView),
                                withParent(withId(R.id.scrollView1))))));
        button.perform(scrollTo(), click());

        ViewInteraction button2 = onView(
                allOf(withId(android.R.id.button3),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("Error"),
                        childAtPosition(
                                allOf(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(android.R.id.button3), withText("Close"), isDisplayed()));
        button3.perform(click());


        editText4.perform(scrollTo(), clearText(), closeSoftKeyboard());
        editText4.perform(scrollTo(), replaceText("company"), closeSoftKeyboard());

        ViewInteraction button4 = onView(
                allOf(withId(R.id.loginButton), withText("Login"),
                        withParent(allOf(withId(R.id.makePaymentView),
                                withParent(withId(R.id.scrollView1))))));
        button4.perform(scrollTo(), click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction button5 = onView(
                allOf(withId(R.id.makePaymentButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView1),
                                        0),
                                2),
                        isDisplayed()));
        button5.check(matches(isDisplayed()));

        ViewInteraction button6 = onView(
                allOf(withId(R.id.mortageRequestButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView1),
                                        0),
                                3),
                        isDisplayed()));
        button6.check(matches(isDisplayed()));

        ViewInteraction button7 = onView(
                allOf(withId(R.id.expenseReportButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView1),
                                        0),
                                4),
                        isDisplayed()));
        button7.check(matches(isDisplayed()));

        ViewInteraction button8 = onView(
                allOf(withId(R.id.logoutButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView1),
                                        0),
                                5),
                        isDisplayed()));
        button8.check(matches(isDisplayed()));

        ViewInteraction button9 = onView(
                allOf(withId(R.id.logoutButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView1),
                                        0),
                                5),
                        isDisplayed()));
        button9.check(matches(isDisplayed()));

        ViewInteraction button10 = onView(
                allOf(withId(R.id.makePaymentButton), withText("Make Payment")));
        button10.perform(scrollTo(), click());

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.phoneTextField), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.makePaymentView),
                                        1),
                                0),
                        isDisplayed()));


        ViewInteraction editText7 = onView(
                allOf(withId(R.id.nameTextField), withText("Name"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.makePaymentView),
                                        2),
                                0),
                        isDisplayed()));

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.amountTextField), withText("Amount"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.makePaymentView),
                                        3),
                                0),
                        isDisplayed()));


        ViewInteraction editText9 = onView(
                allOf(withId(R.id.countryTextField), withText("Country"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.makePaymentView),
                                        4),
                                0),
                        isDisplayed()));

        ViewInteraction editText10 = onView(
                allOf(withId(R.id.countryTextField), withText("Country"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.makePaymentView),
                                        4),
                                0),
                        isDisplayed()));


        ViewInteraction button11 = onView(
                allOf(withId(R.id.countryButton), withText("Select")));
        button11.perform(scrollTo(), click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.rowTextView), withText("India"),
                        childAtPosition(
                                allOf(withId(R.id.countryList),
                                        childAtPosition(
                                                withId(R.id.makePaymentView),
                                                0)),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("India")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.rowTextView), withText("USA"),
                        childAtPosition(
                                allOf(withId(R.id.countryList),
                                        childAtPosition(
                                                withId(R.id.makePaymentView),
                                                0)),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("USA")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.rowTextView), withText("USA"),
                        childAtPosition(
                                allOf(withId(R.id.countryList),
                                        childAtPosition(
                                                withId(R.id.makePaymentView),
                                                0)),
                                1),
                        isDisplayed()));
        textView4.check(matches(withText("USA")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.rowTextView), withText("India"),
                        childAtPosition(
                                allOf(withId(R.id.countryList),
                                        withParent(withId(R.id.makePaymentView))),
                                0),
                        isDisplayed()));
        textView5.perform(click());

        ViewInteraction editText11 = onView(
                withId(R.id.phoneTextField));
        editText11.perform(scrollTo(), click());

        ViewInteraction editText12 = onView(
                withId(R.id.phoneTextField));
        editText12.perform(scrollTo(), click());

        ViewInteraction editText13 = onView(
                withId(R.id.phoneTextField));
        editText13.perform(scrollTo(), replaceText("rr"), closeSoftKeyboard());

        ViewInteraction editText14 = onView(
                withId(R.id.nameTextField));
        editText14.perform(scrollTo(), replaceText("r"), closeSoftKeyboard());

        ViewInteraction editText15 = onView(
                withId(R.id.amountTextField));
        editText15.perform(scrollTo(), replaceText("12"), closeSoftKeyboard());

        ViewInteraction button12 = onView(
                allOf(withId(R.id.sendPaymentButton),
                        childAtPosition(
                                allOf(withId(R.id.makePaymentView),
                                        childAtPosition(
                                                withId(R.id.scrollView1),
                                                0)),
                                5),
                        isDisplayed()));
        button12.check(matches(isDisplayed()));

        ViewInteraction button13 = onView(
                allOf(withId(R.id.sendPaymentButton), withText("Send Payment"),
                        withParent(allOf(withId(R.id.makePaymentView),
                                withParent(withId(R.id.scrollView1))))));
        button13.perform(scrollTo(), click());

        ViewInteraction button14 = onView(
                allOf(withId(android.R.id.button1), withText("Yes"), isDisplayed()));
        button14.perform(click());

        ViewInteraction view = onView(
                allOf(withContentDescription(new StringContains("Your balance is:")),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.webkit.WebView.class),
                                        0),
                                0),
                        isDisplayed()));
        ViewInteraction button15 = onView(
                allOf(withId(R.id.logoutButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView1),
                                        0),
                                5),
                        isDisplayed()));
        button15.check(matches(isDisplayed()));
        button15.perform(click());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
