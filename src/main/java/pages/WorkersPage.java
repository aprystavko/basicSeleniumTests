package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class WorkersPage extends ParentPage {
    protected MainPage mainPage;

    public WorkersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/workers");
        mainPage = new MainPage(webDriver);
    }

    @FindBy(id = "workers")
    private WebElement subMenuWorkers;

    @FindBy(xpath = ".//*[@data-toggle='tooltip']")
    private WebElement workerCreateButton;

    @FindBy(id = "workers_workerSurname")
    private WebElement workerSurnameInput;

    @FindBy(id = "workers_workerName")
    private WebElement workerNameInput;

    @FindBy(id = "workers_workerMiddleName")
    private WebElement workerMidInput;

    @FindBy(id = "workers_workerPhone")
    private WebElement workerPhoneInput;

    @FindBy(xpath = ".//button[@name='add']")
    private WebElement workerSaveButton;

    @FindBy(xpath = ".//*[text()='Петренко Петр Николаевич']")
    private WebElement worker;

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement workerDeleteeButton;


    public void deleteAllWorkersWhenTheyArePresent(String workerSurname, String workerName, String workerMidname) {
        while (isCreatedWorkerPresent(workerSurname, workerName, workerMidname)) {
            deleteWorker(workerSurname, workerName, workerMidname);
        }
    }

    public boolean isCreatedWorkerPresent(String workerSurname, String workerName, String workerMidname) {
        String fullUserName = workerSurname + " " + workerName + " " + workerMidname;
        try {
            return isElementPresent(webDriver.findElement(By.xpath(".//*[text()='" + fullUserName + "']")));
        } catch (Exception e) {
            logger.info(fullUserName + " worker wasn't found");
            return false;
        }
    }

    public void createNewWorker(String workerSurname, String workerName, String workerMidname, String workerPhone) {
        clickOnElement(workerCreateButton);
        enterTextIntoInput(workerSurnameInput, workerSurname);
        enterTextIntoInput(workerNameInput, workerName);
        enterTextIntoInput(workerMidInput, workerMidname);
        enterTextIntoInput(workerPhoneInput, workerPhone);
        clickOnElement(workerSaveButton);
    }

    public void checkNewWorkerCreation(String workerSurname, String workerName, String workerMidname, String workerPhone) {
        webDriver.navigate().refresh();
        String fullUserName = workerSurname + " " + workerName + " " + workerMidname;
        clickOnElement(webDriver.findElement(By.xpath(".//*[text()='" + fullUserName + "']")));
        Assert.assertEquals("Value in workerSurname hasn't expected", workerSurname, workerSurnameInput.getAttribute("value"));
        Assert.assertEquals("Value in workerName hasn't expected", workerName, workerNameInput.getAttribute("value"));
        Assert.assertEquals("Value in workerMidname hasn't expected", workerMidname, workerMidInput.getAttribute("value"));
        Assert.assertEquals("Value in workerPhone hasn't expected", workerPhone, workerPhoneInput.getAttribute("value"));
    }

    public void deleteWorker(String workerSurname, String workerName, String workerMidname) {
        String fullUserName = workerSurname + " " + workerName + " " + workerMidname;
        clickOnElement(webDriver.findElement(By.xpath(".//*[text()='" + fullUserName + "']")));
        clickOnElement(workerDeleteeButton);
        logger.info("Worker deleted: " + fullUserName);
    }

}

