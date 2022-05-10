package automationpractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.MyStorePage;

public class ReviewTest extends BaseTest {

    String authUrl = "http://automationpractice.com/index.php?controller=authentication&email=testmail_skup@gmail.com&passwd=12345&back=my-account&SubmitLogin=";

    //    By womenCategory = By.cssSelector("a.sf-with-ul[title='Women']");
    //    By summerDressesCategory = By.cssSelector("ul.submenu-container[style*='display: block;']   a[title*='Summer Dresses']");
    By womenCategory = By.cssSelector("a[title*='Women']");
    By casualDressesCategory = By.cssSelector("a[title*='Casual Dresses']");
    By summerDressesCategory = By.cssSelector("a[title*='Summer Dresses']");

    @Test
    void leaveAComment() throws InterruptedException {
        driver.get(authUrl);
        HomePage.open(driver);
        Actions actions = new Actions(driver);
        WebElement womenLink = driver.findElement(womenCategory);
        WebElement summerDressesLink = driver.findElement(summerDressesCategory);
        actions
                .moveToElement(womenLink)
                .moveToElement(summerDressesLink)
                .click()
                .perform();

        MyStorePage myStore = new MyStorePage(driver);
        int items = myStore.getShopItems().size();
        Assertions.assertEquals(3, items, "number of closes items");
    }
}
