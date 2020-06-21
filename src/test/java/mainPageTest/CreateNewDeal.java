package mainPageTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

import static pages.ParentPage.configProperties;

public class CreateNewDeal extends ParentTest {

    final String dealTypeName = "Молекула";

    @Before
    public void beforeCreateNewApparat() {
        loginPage.userLogin(configProperties.valid_user_login(), configProperties.valid_user_password());
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuDeal();
        dealTypePage.deleteAllDealWhenTheyArePresent(dealTypeName);
    }

    @Test
    public void createNewApparat() {
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuDeal();
        dealTypePage.createNewDeal(dealTypeName);
        dealTypePage.checkNewDealCreation(dealTypeName);
    }

    @After
    public void afterCreateNewApparat() {
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuApparat();
        if (dealTypePage.isCreatedDealPresent(dealTypeName)) {
            dealTypePage.deleteDeal(dealTypeName);
        }
    }

}