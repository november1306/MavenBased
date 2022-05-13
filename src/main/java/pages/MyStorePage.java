package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyStorePage extends BaseShopPage {
    By shopItem = By.xpath("//div[@class='product-container']");
    By girly = By.cssSelector("input.checkbox#layered_id_feature_13");
    By productName = By.cssSelector(".product-name");
    String dress = "a.product-name[title*='%s']";


    public MyStorePage(WebDriver driver) {
        super(driver);
        //todo check on page
    }

    public List<WebElement> getShopItems() {
        return driver.findElements(shopItem);
    }


    public MyStorePage enableGirlyCheckbox() {
        WebElement girlyCheckbox = driver.findElement(girly);
        if (!girlyCheckbox.isSelected()) {
            girlyCheckbox.click();
        }
        return this;
    }

    public ProductDetailsPage viewDressDetails(int itemIndex) {
        List<WebElement> shopItems = getShopItems();
        shopItems.get(itemIndex)
                .findElement(productName)
                .click();
        return new ProductDetailsPage(driver);
    }

    public ProductDetailsPage viewDressDetails(String itemTitle) {
        By dressItemLocator = By.cssSelector(String.format(dress, itemTitle));
        driver.findElement(dressItemLocator).click();
        return new ProductDetailsPage(driver);
    }
}
