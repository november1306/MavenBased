package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private final WebDriver driver;
    public By accountLocator = By.cssSelector("a.account span");
    public By navigationPanelLocator = By.cssSelector("span.navigation_page");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        checkOnPage();
    }

    public String getAuthorizedAccount() {
        return driver.findElement(accountLocator).getText();
    }

    public void checkOnPage() {
        WebElement navigationPanel = driver.findElement(navigationPanelLocator);
        if ("My Account".equals(navigationPanel.getText()))
            throw new IllegalStateException("This is not the MyAccountPage page");

    }
}
