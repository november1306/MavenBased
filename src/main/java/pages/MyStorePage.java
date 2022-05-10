package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyStorePage extends ShopBasePage {
    By shopItem = By.xpath("//div[@class='product-container']");
    //By.className("product-container");
    //  By.cssSelector(".product_list .product-container");

    public MyStorePage(WebDriver driver) {
        super(driver);
        //todo check on page
    }

    public List<WebElement> getShopItems() {
        return driver.findElements(shopItem);
    }


}
