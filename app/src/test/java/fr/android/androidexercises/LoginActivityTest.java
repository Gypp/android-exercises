package fr.android.androidexercises;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;

import static org.junit.Assert.*;

/**
 * Created by Gwénaël on 22/01/2016.
 */
@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTest {

    LoginActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void testNotLogged() throws Exception {
        activity.notLogged();
        Assertions.assertThat(activity.loginLayout).isNotGone();
        Assertions.assertThat(activity.loggedText).isNotVisible();
    }

    @Test
    public void testLogged() throws Exception {
        activity.logged();
        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void testMessage() throws Exception {

    }
}