package automationpractice;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.HomePage;
import pages.MyAccountPage;
import utils.PropertyReader;
import utils.WebDriverUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AuthorizationTest extends BaseTest {

    @AfterEach
    public void allureAttachScreenshot() {
        File screenShot = WebDriverUtils.getScreenshot(driver);
        try {
            Allure.addAttachment("authorize test screenshot", Files.newInputStream(screenShot.toPath()));
        } catch (IOException e) {
            System.err.println("could not attach screenshot");
        }
    }

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
