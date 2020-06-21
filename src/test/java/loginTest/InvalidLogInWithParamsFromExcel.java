package loginTest;
// Вариант для получения много наборов данных из экселя

import libs.SpreadsheetData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import static pages.ParentPage.configProperties;

@RunWith(value = Parameterized.class)
public class InvalidLogInWithParamsFromExcel extends ParentTest {
    String login, password;

    public InvalidLogInWithParamsFromExcel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "login = {0} pass = {1}")
    public static Collection testData() throws IOException {

        InputStream spreadSheet = new FileInputStream(
                configProperties.DATA_FILE_SUITE() + "testDataSuit.xls"
        );
        // InvalidLogOn - имя листа в экселе в файле testDataSuit.xls
        return new SpreadsheetData(spreadSheet, "InvalidLogOn").getData();
    }

    @Test
    public void InvalidLogInWithParamsFromExcel() {
        waitTimeWhenLoadingPage.WaitTimeWhenLoadingPage();
        loginPage.userLoginIE(login, password);
        Assert.assertTrue("Login input doesn't displayed", loginPage.isLoginInputDisplay());
        Assert.assertFalse("User should not be logged", mainPage.isAvatarPresent());
    }

}
