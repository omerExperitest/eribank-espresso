package com.experitest.ExperiBank;


import android.support.test.espresso.ViewInteraction;
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
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LongLogin {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void loginActivityTest() {
        for(int i = 0; i < 40; i ++) {
            runTest();
        }
    }

    private void runTest() {
        ViewInteraction editText = onView(
                withId(R.id.usernameTextField));
        editText.perform(scrollTo(), click());

        ViewInteraction editText2 = onView(
                withId(R.id.usernameTextField));
        editText2.perform(scrollTo(), click());

        ViewInteraction editText3 = onView(
                withId(R.id.usernameTextField));
        editText3.perform(scrollTo(), click());

        ViewInteraction editText4 = onView(
                withId(R.id.usernameTextField));
        editText4.perform(scrollTo(), replaceText("company"), closeSoftKeyboard());

        ViewInteraction editText5 = onView(
                withId(R.id.passwordTextField));
        editText5.perform(scrollTo(), replaceText("company"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withId(R.id.loginButton),
                        childAtPosition(
                                allOf(withId(R.id.makePaymentView),
                                        childAtPosition(
                                                withId(R.id.scrollView1),
                                                0)),
                                3),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.loginButton), withText("Login"),
                        withParent(allOf(withId(R.id.makePaymentView),
                                withParent(withId(R.id.scrollView1))))));
        button2.perform(scrollTo(), click());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.makePaymentButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView1),
                                        0),
                                2),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction button4 = onView(
                allOf(withId(R.id.logoutButton), withText("Logout")));
        button4.perform(scrollTo(), click());

        ViewInteraction textView = onView(
                allOf(withText("Hint:company"),
                        childAtPosition(
                                allOf(withId(R.id.makePaymentView),
                                        childAtPosition(
                                                withId(R.id.scrollView1),
                                                0)),
                                4),
                        isDisplayed()));
        textView.check(matches(withText("Hint:company")));
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
