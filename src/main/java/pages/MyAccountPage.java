package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class MyAccountPage extends ShopBasePage {

    By navigationPanelLocator = By.cssSelector("span.navigation_page");

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
