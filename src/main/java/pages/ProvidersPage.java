package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class ProvidersPage extends ParentPage {
    protected MainPage mainPage;


    public ProvidersPage (WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        mainPage = new MainPage(webDriver);
    }

    @FindBy(id = "spareType")
    private WebElement subMenuSpareType;

    @FindBy(xpath = ".//*[@data-toggle='tooltip']")
    private WebElement workerCreateButton;

    @FindBy(id = "spareType_spareTypeName")
    private WebElement spareTypeNameInput;

    @FindBy(xpath = ".//button[@name='add']")
    private WebElement workerSaveButton;

    @FindBy(xpath = ".//*[text()='Механика']")
    private WebElement spareType;

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement workerDeleteeButton;

}

