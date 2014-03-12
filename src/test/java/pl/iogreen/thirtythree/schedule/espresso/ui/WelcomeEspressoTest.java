package pl.iogreen.thirtythree.schedule.espresso.ui;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import pl.iogreen.thirtythree.schedule.R;
import pl.iogreen.thirtythree.schedule.ui.WelcomeActivity;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class WelcomeEspressoTest extends ActivityInstrumentationTestCase2<WelcomeActivity> {

    public WelcomeEspressoTest() {
        super("pl.iogreen.thirtythree.schedule", WelcomeActivity.class);
//        super(WelcomeActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    public void testCheckText() {
        onView(withId(R.id.scheduleList))
                .check(matches(withText("Hello Espresso!")));
    }
}
