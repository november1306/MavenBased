package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderWidget {
    WebDriver driver;

    By signInButton = By.className("login");
    By signOutButton = By.className("logout");
    By accountLocator = By.cssSelector("a.account span");
    By shoopingCart = By.className("shopping_cart");

    public HeaderWidget(WebDriver driver) {
        this.driver = driver;
    }

    public AuthorizationPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new AuthorizationPage(driver);
    }

    public String getAuthorizedAccount() {
        return driver.findElement(accountLocator).getText();
    }
    public boolean isUnAuthorizedAccount() {
        List<WebElement> logIn = driver.findElements(signInButton);
        return logIn.isEmpty();
    }

}
