package parentTest;

import libs.ActionsWithOurElements;
import libs.WaitTimeWhenLoadingPage;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static pages.ParentPage.configProperties;


public class ParentTest {

    public WebDriver webDriver;
    String browser = System.getProperty("browser");
    Logger log;

    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected UserProfile userProfile;
    protected SparesPage sparesPage;
    protected ApparatPage apparatPage;
    protected ActionsWithOurElements actionsWithOurElements;
    protected WaitTimeWhenLoadingPage waitTimeWhenLoadingPage;

    protected DealTypePage dealTypePage;
    protected ProvidersPage providersPage;
    protected SpareTypePage spareTypePage;
    protected WorkersPage workersPage;

    @Before
    public void setUp() {
        log = Logger.getLogger(getClass());
        setBrowser();

        webDriver.manage().timeouts().implicitlyWait(configProperties.TIME_FOR_DFFAULT_WAIT(), TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        String winHandleBefore = webDriver.getWindowHandle();
        webDriver.switchTo().window(winHandleBefore);

        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        userProfile = new UserProfile(webDriver);
        apparatPage = new ApparatPage(webDriver);
        waitTimeWhenLoadingPage = new WaitTimeWhenLoadingPage();

        dealTypePage = new DealTypePage(webDriver);
        providersPage = new ProvidersPage(webDriver);
        spareTypePage = new SpareTypePage(webDriver);
        workersPage = new WorkersPage(webDriver);

        sparesPage = new SparesPage(webDriver);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

    private void setBrowser() {
        if (browser == null) {
            browser = "chrome";
        }

        if ("chrome".equals(browser)) {
            File fileFireFox = new File("src/main/resources/chromedriver");
            System.setProperty("webdriver.chrome.driver", fileFireFox.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else {
            Assert.fail("Can't open browser" + browser);
        }
    }

    protected void checkAC(String message, Boolean actual, Boolean expected) {
        Assert.assertEquals(message + "Browser - " + browser, actual, expected);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}