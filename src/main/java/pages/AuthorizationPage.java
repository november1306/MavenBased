package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizationPage {
    private final String pageURL = "http://automationpractice.com/index.php?controller=authentication";
    private final WebDriver driver;

    public By signInLocator = By.id("SubmitLogin");
    public By emailInputLocator = By.cssSelector("input#email");
    public By passwordInputLocator = By.xpath("//input[@id='passwd']");
    public By navigationPanelLocator = By.cssSelector("span.navigation_page");
    public By newEmailAccountField = By.xpath("//*[@id = 'email_create']");
    public By createNewAccountButton = By.xpath("//*[@id='SubmitCreate']");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage doAuthorize(String login, String password) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(login);

        WebElement passInput = driver.findElement(passwordInputLocator);
        passInput.sendKeys(password);

        WebElement signInButton = driver.findElement(signInLocator);
        signInButton.click();

        return new MyAccountPage(driver);
    }

    public CreateAccountPage startRegistrationPage(String userEmail){
        WebElement emailInput = driver.findElement(newEmailAccountField);
        emailInput.sendKeys(userEmail);
        WebElement createAccountButton = driver.findElement(createNewAccountButton);
        createAccountButton.click();

        return new CreateAccountPage(driver);
    }

}
