package com.example.wordcounter;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Rule;
import org.junit.Test;

public class WordCounterUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testInputWordCount() {
        Espresso.onView(ViewMatchers.withId(R.id.edUserInput))
                .perform(ViewActions.typeText("Hello world"));

        Espresso.onView(ViewMatchers.withId(R.id.spSelectionOptions))
                .perform(ViewActions.click());
        Espresso.onData(ViewMatchers.withText("Words"))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.button))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.tvCountResult))
                .check(ViewAssertions.matches(ViewMatchers.withText("Words count: 2")));
    }
}
