package suits;

import loginTest.Login;
import loginTest.Logout;
import mainPageTest.CreateNewApparat;
import mainPageTest.CreateNewDeal;
import mainPageTest.CreateNewWorker;
import mainPageTest.UpdateUserProfile;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spareTest.AddNewSpareTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                Login.class,
                Logout.class,
                CreateNewApparat.class,
                CreateNewDeal.class,
                CreateNewWorker.class,
                UpdateUserProfile.class,
                AddNewSpareTest.class
        }
)

public class TestAllSuit {

}
