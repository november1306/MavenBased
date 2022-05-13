package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BaseShopPage {
    By reviewContainer = By.cssSelector("form#id_new_comment_form");
    By newReview = By.cssSelector("ul.comments_advices a.open-comment-form");
    By reviewTitle = By.cssSelector("input#comment_title");
    By reviewComment = By.cssSelector("textarea#content");
    By review5Star = By.cssSelector("div.star a[title='5']");
    By reviewSend = By.cssSelector("button#submitNewMessage");
    By confirmHeader = By.cssSelector("div.fancybox-inner > h2");


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }


    public void createReview(int rating, String title, String comment) {
        driver.findElement(newReview).click();
        driver.findElement(reviewTitle).sendKeys(title);
        driver.findElement(reviewComment).sendKeys(comment);

        if (rating >= 0 && rating <= 5) {
            driver.findElement(review5Star).click();
        }
        driver.findElement(reviewSend).click();
    }

    public String getConfirmReviewHeader() {
        return driver.findElement(confirmHeader).getText();
    }

}
