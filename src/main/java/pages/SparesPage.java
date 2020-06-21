package pages;

import libs.ActionsWithOurElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.clickOnElement;
import static libs.ActionsWithOurElements.isElementPresent;

public class SparesPage extends ParentPage {

    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement addNewSpare;

    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareSelectType;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement createSpareButon;

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement deleteSpareButton;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement addSpareButton;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void createNewSpare(String spareName, String spareType) {
        clickOnElement(addNewSpare);
        ActionsWithOurElements.enterTextIntoInput(spareNameInput, spareName);
        ActionsWithOurElements.clickOnElement(addSpareButton);
        WebElement optionValueType = webDriver.findElement(By.xpath(".//option[text()='" + spareType + "'][1]"));
        actionsWithOurElements.selectOptionsInDropDown(spareSelectType, optionValueType);
        clickOnElement(createSpareButon);
    }

    public void deleteSpare(String spareName) {
        clickOnElement(webDriver.findElement(By.xpath(".//*[text()='" + spareName + "']")));
        clickOnElement(deleteSpareButton);
        logger.info("Spare deleted " + spareName);
    }

    public boolean isCreatedSpareIsPresent(String spareName) {
        try {
            return isElementPresent(webDriver.findElement(By.xpath(".//*[text()='" + spareName + "']")));
        } catch (Exception e) {
            logger.info(spareName + " spare wasn't found");
            return false;
        }
    }

    public void deleteAllSparesWhenTheyArePresent(String spareName) {
        while (isCreatedSpareIsPresent(spareName)) {
            deleteSpare(spareName);
        }
    }

}
