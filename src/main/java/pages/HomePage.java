package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;
import java.util.NoSuchElementException;

public class HomePage extends BaseShopPage {
    private static final String pageURL = PropertyReader.BASEURL;


    public HomePage(WebDriver driver) {
        super(driver);
        checkOnPage();
    }

    public static HomePage open(WebDriver driver) {
        driver.navigate().to(pageURL);
        return new HomePage(driver);
    }


    public void checkOnPage() {
        if (!"My Store".equals(driver.getTitle()))
            throw new IllegalStateException("This is not the Home page");
    }

    public HomePage waitOnPage() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.pollingEvery(Duration.ofSeconds(3));
        wait.ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(contactUs));
        return this;
    }


}
