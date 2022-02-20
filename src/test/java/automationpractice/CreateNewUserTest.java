package automationpractice;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.CreateAccountPage;
import utils.PropertyReader;


public class CreateNewUserTest extends BaseTest {
    Fairy fairy = Fairy.create();
    Person person = fairy.person();

    @Test
    public void creatingUser() {
        driver.get(PropertyReader.BASEURL);
        HomePage homePage = new HomePage(driver).waitOnPage();
        AuthorizationPage authorizationPage = homePage.clickSignIn();
        authorizationPage.checkOnPage();
        CreateAccountPage createAccountPage = authorizationPage.openRegistrationPage(person.getCompanyEmail());
        createAccountPage.checkOpeningRegistrationPage();
        createAccountPage.fillFormForCreatingUser(person.getFirstName(), person.getLastName(), person.getPassword(),"623 Pendergast Court","Florida","Florida","33015", person.getTelephoneNumber());
        new MyAccountPage(driver).checkOnPage();
    }
}
