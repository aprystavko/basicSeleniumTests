package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class DealTypePage extends ParentPage {
    protected MainPage mainPage;

    public DealTypePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/deal_type");
        mainPage = new MainPage(webDriver);
    }

    @FindBy(id = "deal_type")
    private WebElement subMenuDealType;

    @FindBy(xpath = ".//*[@data-toggle='tooltip']")
    private WebElement dealTypeCreateButton;

    @FindBy(id = "deal_type_dealTypeName")
    private WebElement dealTypeNameInput;

    @FindBy(xpath = ".//button[@name='add']")
    private WebElement providerSaveButton;

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement providerDeleteButton;

    public boolean isCreatedDealPresent(String dealTypeName) {
        try {
            return isElementPresent(webDriver.findElement(By.xpath(".//*[text()='" + dealTypeName + "']")));
        } catch (Exception e) {
            logger.info(dealTypeName + " deal wasn't found");
            return false;
        }
    }

    public void deleteAllDealWhenTheyArePresent(String dealTypeName) {
        while (isCreatedDealPresent(dealTypeName)) {
            deleteDeal(dealTypeName);
        }
    }

    public void createNewDeal(String dealTypeName) {
        clickOnElement(dealTypeCreateButton);
        enterTextIntoInput(dealTypeNameInput, dealTypeName);
        clickOnElement(providerSaveButton);
    }

    public void checkNewDealCreation(String dealTypeName) {
        webDriver.navigate().refresh();
        clickOnElement(webDriver.findElement(By.xpath("./*//*[text()='" + dealTypeName + "']")));
        Assert.assertEquals("Value in dealTypeName hasn't expected", dealTypeName, dealTypeNameInput.getAttribute("value"));
    }

    public void deleteDeal(String dealTypeName) {
        clickOnElement(webDriver.findElement(By.xpath("./*//*[text()='" + dealTypeName + "']")));
        clickOnElement(providerDeleteButton);
        logger.info("Deal deleted: " + dealTypeName);
    }

}

