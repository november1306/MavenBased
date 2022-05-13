package automationpractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.MyStorePage;
import pages.ProductDetailsPage;

public class ReviewTest extends BaseTest {

    String authUrl = "http://automationpractice.com/index.php?controller=authentication&email=testmail_skup@gmail.com&passwd=12345&back=my-account&SubmitLogin=";

    Logger log = LoggerFactory.getLogger(ReviewTest.class);

    @Test
    @DisplayName("write item review")
    void leaveAComment() {
        log.info("start leave_a_comment_test");
        driver.get(authUrl);
        HomePage.open(driver);

        log.info("navigate to Summer dresses shop page");
        MyStorePage myStorePage = navigateToSummerDresses();
        myStorePage.enableGirlyCheckbox();

        log.info("try to click on first shop item");
        ProductDetailsPage detailsPage = myStorePage.viewDressDetails(1);
//        myStorePage.viewDressDetails("Chiffon");

        detailsPage.createReview(5, "my review", "pretty good dress");
        String confirmationText = detailsPage.getConfirmReviewHeader();

        Assertions.assertEquals("New comment", confirmationText, "dress review was not created");
        log.info("end leave_a_comment_test");
    }

}
