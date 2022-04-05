package automationpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

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
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
