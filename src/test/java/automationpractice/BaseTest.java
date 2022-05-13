package automationpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.MyStorePage;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    By womenCategory = By.cssSelector("a[title*='Women']");
    By casualDressesCategory = By.cssSelector("a[title='Women'] + ul a[title='Casual Dresses']");
    By summerDressesCategory = By.cssSelector("a[title='Women'] + ul a[title='Summer Dresses']");

    protected WebDriver driver;
    Logger log = LoggerFactory.getLogger(getClass());

    @BeforeEach
    public void initDriver() {
        String browser = PropertyReader.BROWSER.toLowerCase();
        switch (browser) {
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("version");

                driver = new ChromeDriver(chromeOptions);
                log.info("Chromedriver initialized");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            }
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                log.info("Firefox initialized");
                break;
            }
            default:
                throw new InvalidArgumentException("cant initialize driver, available options: chrome, firefox");
        }
    }

    public MyStorePage navigateToSummerDresses() {
        Actions actions = new Actions(driver);
        WebElement womenLink = driver.findElement(womenCategory);

        WebElement summerDressesLink = driver.findElement(summerDressesCategory);
        actions
                .moveToElement(womenLink)
                .moveToElement(summerDressesLink)
                .click()
                .perform();

        return new MyStorePage(driver);
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
