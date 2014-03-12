package pl.iogreen.thirtythree.schedule;

import com.google.inject.AbstractModule;
import com.google.inject.util.Modules;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import pl.iogreen.thirtythree.schedule.service.SomeService;
import pl.iogreen.thirtythree.schedule.ui.WelcomeActivity;
import roboguice.RoboGuice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class BaseActivityRoboTest {

    private WelcomeActivity activity;
    private SomeService someServiceMock = Mockito.mock(SomeService.class);

    @Before
    public void setUp() {
        RoboGuice.setBaseApplicationInjector(Robolectric.application, RoboGuice.DEFAULT_STAGE, Modules.override(RoboGuice.newDefaultRoboModule(Robolectric.application)).with(new MyTestModule()));

        activity = Robolectric.buildActivity(WelcomeActivity.class).create().get();
    }

    @Test
    public void testSomething() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void testStringShouldEndInExclamationMark() throws Exception {
        assertEquals("Thirty Three Schedule", activity.getTitle());
    }

    private class MyTestModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(SomeService.class).toInstance(someServiceMock);
        }
    }
}
