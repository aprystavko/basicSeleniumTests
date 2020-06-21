package mainPageTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

import static pages.ParentPage.configProperties;

public class CreateNewWorker extends ParentTest {

    final String workerSurname = "Ivanov";
    final String workerName = "Vladimir";
    final String workerMiddleName = "Ivanovich";
    final String workerPhone = "+380-99-999-99";

    @Before
    public void beforeCreateNewWorker() {
        loginPage.userLogin(configProperties.valid_user_login(), configProperties.valid_user_password());
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuWorker();
        workersPage.deleteAllWorkersWhenTheyArePresent(workerSurname, workerName, workerMiddleName);
    }

    @Test
    public void createNewWorker() {
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuWorker();
        workersPage.createNewWorker(workerSurname, workerName, workerMiddleName, workerPhone);
        workersPage.checkNewWorkerCreation(workerSurname, workerName, workerMiddleName, workerPhone);
    }

    @After
    public void afterCreateNewWorker() {
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuWorker();
        if (workersPage.isCreatedWorkerPresent(workerSurname, workerName, workerMiddleName)) {
            workersPage.deleteWorker(workerSurname, workerName, workerMiddleName);
        }
    }

}