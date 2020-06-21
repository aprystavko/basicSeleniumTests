package loginTest;

import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

import static pages.ParentPage.configProperties;

public class LoginTestExcel extends ParentTest {

    // Вариант для получения одного набора данных из экселя
    private ExcelDriver excelDriver;

    @Test
    public void userLogin() throws IOException {
        // Имя листа в экселе - validLogOn, файл testData.xls тянется из проперти, getData key  с 1-й колонки, value со 2-й колонки
        Map data = ExcelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPage.userLogin(data.get("login").toString(), data.get("pass").toString());
        Assert.assertTrue("Avatar isn't present", mainPage.isAvatarPresent());
        Assert.assertTrue("Menu items aren't present", mainPage.isMenuItemsPresent());
    }


}