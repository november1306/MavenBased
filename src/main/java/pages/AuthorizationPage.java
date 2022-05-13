package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizationPage extends BaseShopPage {
    private final String pageURL = "http://automationpractice.com/index.php?controller=authentication";

     By signInButton = By.id("SubmitLogin");
     By emailInput = By.cssSelector("input#email");
     By passwordInput = By.xpath("//input[@id='passwd']");
     By navigationPanel = By.cssSelector("span.navigation_page");


    public AuthorizationPage(WebDriver driver) {
        super(driver);
        checkOnPage();
    }

    public AuthorizationPage open() {
        driver.navigate().to(pageURL);
        return this;
    }

    public MyAccountPage doAuthorize(String login, String password) {
        WebElement emailInput = driver.findElement(this.emailInput);
        emailInput.sendKeys(login);

        WebElement passInput = driver.findElement(passwordInput);
        passInput.sendKeys(password);

        WebElement signInButton = driver.findElement(this.signInButton);
        signInButton.click();
        return new MyAccountPage(driver);
    }

    public void checkOnPage() {
        WebElement navigationPanel = driver.findElement(this.navigationPanel);

        if (!"Authentication".equals(navigationPanel.getText())) {
            throw new IllegalStateException("This is not the Authorization page");
        }
    }

}
