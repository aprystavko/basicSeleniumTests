package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class InvalidLogInWithParams extends ParentTest {
    String login, password;

    public InvalidLogInWithParams(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "login = {0} pass = {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", ""},
                {"", "1111"},
                {"Student", "1111"},
                {"Student", "906090"}
        });
    }

    @Test
    public void InvalidLogInWithParams() {
        waitTimeWhenLoadingPage.WaitTimeWhenLoadingPage();
        loginPage.userLoginIE(login, password);
        Assert.assertTrue("Login input doesn't displayed", loginPage.isLoginInputDisplay());
        Assert.assertFalse("User should not be logged", mainPage.isAvatarPresent());
    }

}
