package automationpractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.HomePage;
import pages.MyAccountPage;
import utils.PropertyReader;

public class AuthorizationTest extends BaseTest {

    @Test
    public void authorizeTest() {
        driver.get(PropertyReader.BASEURL);
        HomePage homePage = new HomePage(driver).waitOnPage();
        AuthorizationPage authorizationPage = homePage.clickSignIn();
        MyAccountPage myAccountPage = authorizationPage.doAuthorize("skillupdemo@gmail.com", "12345");
        String account = myAccountPage.getAuthorizedAccount();
        Assertions.assertEquals("name lasr", account);
    }
}
