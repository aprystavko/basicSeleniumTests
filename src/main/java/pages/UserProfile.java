package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.clickOnElement;
import static libs.ActionsWithOurElements.enterTextIntoInput;

public class UserProfile extends ParentPage {
    public UserProfile(WebDriver webDriver) {
        super(webDriver, "/users/profile/13");
    }

    @FindBy(xpath = ".//span[@class='hidden-xs']")
    private WebElement userProfile;

    @FindBy(xpath = ".//a[@href='/users/profile/13']")
    private WebElement openUserProfileButton;

    @FindBy(id = "userProfileEdit_user_email")
    private WebElement inputEmail;

    @FindBy(id = "userProfileEdit_user_name")
    private WebElement inputUserName;

    @FindBy(xpath = ".//button[@name='save']")
    private WebElement userProfileSaveButton;

    public void openUserProfile() {
        clickOnElement(userProfile);
        clickOnElement(openUserProfileButton);
    }

    public void updateUserProfile(String email, String userName) {
        enterTextIntoInput(inputEmail, email);
        enterTextIntoInput(inputUserName, userName);
        logger.info("UserProfile was update: " + email + ", " + userName);
        clickOnElement(userProfileSaveButton);
    }

    public void checkUpdateUserInfo(String email, String userName) {
        Assert.assertEquals("Username isn't updated", userName, userProfile.getText());
        Assert.assertEquals("Username isn't updated", userName, inputUserName.getAttribute("value"));
        Assert.assertEquals("User email isn't updated", email, inputEmail.getAttribute("value"));
    }
}