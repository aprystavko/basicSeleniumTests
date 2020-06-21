package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpareTypePage extends ParentPage {
    protected MainPage mainPage;


    public SpareTypePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spare_type");
        mainPage = new MainPage(webDriver);
    }

    @FindBy(id = "prov_cus")
    private WebElement subMenuProviders;

    @FindBy(xpath = ".//*[@data-toggle='tooltip']")
    private WebElement providerCreateButton;

    @FindBy(id = "prov_cus_proCustName")
    private WebElement providerNameInput;

    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement providerAdressInput;

    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement providerPhoneInput;

    @FindBy(xpath = ".//button[@name='add']")
    private WebElement workerSaveButton;

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement privatePersonCheckBox;

    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement isOurFirmCheckBox;

    @FindBy(xpath = ".//*[text()='Add Provider']")
    private WebElement providerSaveButton;

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement providerDeleteeButton;

}

