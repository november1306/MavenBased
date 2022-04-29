package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class MyAccountPage extends ShopBasePage {
//    private final WebDriver driver;
     By accountLocator = By.cssSelector("a.account span");
     By navigationPanelLocator = By.cssSelector("span.navigation_page");
     By signInLocator = By.id("SubmitLogin");

    public MyAccountPage(WebDriver driver) {
        super(driver);
        checkOnPage();
    }



    public void checkOnPage() {
        WebElement navigationPanel = driver.findElement(navigationPanelLocator);
        if ("My Account".equals(navigationPanel.getText()))
            throw new IllegalStateException("This is not the MyAccountPage page");

    }
}
