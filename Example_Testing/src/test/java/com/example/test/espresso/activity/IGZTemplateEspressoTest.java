package com.example.test.espresso.activity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import com.example.app.R;
import com.example.app.screen.HomeScreen;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class IGZTemplateEspressoTest extends ActivityInstrumentationTestCase2<HomeScreen> {

    @SuppressWarnings("deprecation")
     public IGZTemplateEspressoTest() {
       // This constructor was deprecated - but we want to support lower API levels.
       super("com.intelygenz.activity", HomeScreen.class);
     }
    @Override
    public void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    public void testCheckText() {
        onView(withId(R.id.row_title))
            .check(matches(withText("Title 1")));
      }
}
