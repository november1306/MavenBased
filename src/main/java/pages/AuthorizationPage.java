package pages;

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

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        checkOnPage();
    }

    public AuthorizationPage open() {
        driver.navigate().to(pageURL);
        return this;
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

    public void checkOnPage() {
        WebElement navigationPanel = driver.findElement(navigationPanelLocator);

        if (!"Authentication".equals(navigationPanel.getText())) {
            throw new IllegalStateException("This is not the Authorization page");
        }
    }

}
