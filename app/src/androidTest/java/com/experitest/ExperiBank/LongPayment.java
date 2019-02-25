package ExperiBankTest2;


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
public class LongPayment {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule(LoginActivity.class);

    @Test
    public void paymentTest() {
        for(int i = 0; i < 40; i ++) {
            makePayment();
        }

    }

    private void makePayment() {

        ViewInteraction editText = onView(
                withId(R.id.usernameTextField));
        editText.perform(scrollTo(), click());

        ViewInteraction editText2 = onView(
                withId(R.id.usernameTextField));
        editText2.perform(scrollTo(), replaceText("company "), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                withId(R.id.passwordTextField));
        editText3.perform(scrollTo(), replaceText("company"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withId(R.id.loginButton), withText("Login"),
                        withParent(allOf(withId(R.id.makePaymentView),
                                withParent(withId(R.id.scrollView1))))));
        button.perform(scrollTo(), click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.makePaymentButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView1),
                                        0),
                                2),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));


        ViewInteraction button3 = onView(
                allOf(withId(R.id.makePaymentButton), withText("Make Payment")));
        button3.perform(scrollTo(), click());

        ViewInteraction editText4 = onView(
                withId(R.id.phoneTextField));
        editText4.perform(scrollTo(), click());

        ViewInteraction editText5 = onView(
                withId(R.id.phoneTextField));
        editText5.perform(scrollTo(), replaceText("0545"), closeSoftKeyboard());

        ViewInteraction editText6 = onView(
                withId(R.id.nameTextField));
        editText6.perform(scrollTo(), replaceText("khaled"), closeSoftKeyboard());

        ViewInteraction editText7 = onView(
                withId(R.id.amountTextField));
        editText7.perform(scrollTo(), replaceText("72"), closeSoftKeyboard());

        ViewInteraction button4 = onView(
                allOf(withId(R.id.countryButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.makePaymentView),
                                        4),
                                1),
                        isDisplayed()));
        button4.check(matches(isDisplayed()));

        ViewInteraction button5 = onView(
                allOf(withId(R.id.countryButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.makePaymentView),
                                        4),
                                1),
                        isDisplayed()));
        button5.check(matches(isDisplayed()));

        ViewInteraction button6 = onView(
                allOf(withId(R.id.countryButton), withText("Select")));
        button6.perform(scrollTo(), click());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.rowTextView), withText("China"),
                        childAtPosition(
                                allOf(withId(R.id.countryList),
                                        withParent(withId(R.id.makePaymentView))),
                                10),
                        isDisplayed()));
        textView2.perform(click());

        ViewInteraction button7 = onView(
                allOf(withId(R.id.sendPaymentButton),
                        childAtPosition(
                                allOf(withId(R.id.makePaymentView),
                                        childAtPosition(
                                                withId(R.id.scrollView1),
                                                0)),
                                5),
                        isDisplayed()));
        button7.check(matches(isDisplayed()));

        ViewInteraction button8 = onView(
                allOf(withId(R.id.sendPaymentButton), withText("Send Payment"),
                        withParent(allOf(withId(R.id.makePaymentView),
                                withParent(withId(R.id.scrollView1))))));
        button8.perform(scrollTo(), click());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction button9 = onView(
                allOf(withId(android.R.id.button1), withText("Yes"), isDisplayed()));
        button9.perform(click());

        ViewInteraction button10 = onView(
                allOf(withId(R.id.logoutButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollView1),
                                        0),
                                5),
                        isDisplayed()));
        button10.check(matches(isDisplayed()));
        button10.perform(click());
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
