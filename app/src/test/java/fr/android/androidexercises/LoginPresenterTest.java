package fr.android.androidexercises;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Gwénaël on 22/01/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest extends TestCase {

    @Mock
    LoginActivity activity;

    @InjectMocks
    LoginPresenter loginPresenter;

    @Test
    public void testCheckCredentials() throws Exception {
        loginPresenter.checkCredentials("password");
        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }

    @Test
    public void testWrongCheckCredentials() throws Exception {
        loginPresenter.checkCredentials("tt");
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }
}