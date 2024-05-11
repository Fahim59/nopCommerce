package Framework.stepDef;

import com.github.javafaker.Faker;
import context.TestContext;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

public class RegistrationDefinition extends BasePage{
    public WebDriver driver;
    private final RegistrationPage registrationPage;

    private static final Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = firstName.toLowerCase() + "@gmail.com";

    private static final Logger logger = LogManager.getLogger(RegistrationDefinition.class);

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public RegistrationDefinition(TestContext context) {
        driver = context.driver;
        registrationPage = PageFactoryManager.getRegistrationPage(context.driver);
    }

    @When("User select the {string} as gender")
    public void userSelectTheTypeAsGender(String type) {
        if(type.equalsIgnoreCase("Male")){
            registrationPage.selectGender("M");
        }
        else{
            registrationPage.selectGender("F");
        }

        logger.info("User selects gender");
    }

    @And("User set first name and last name")
    public void userSetFirstNameAndLastName() {
        registrationPage.setFullName(firstName, lastName);

        logger.info("User set first and last name");
    }

    @And("User set {string} as date of birth")
    public void userSetDobAsDateOfBirth(String date) {
        String[] components = date.split("/");

        String day = components[0];
        String month = components[1];
        String year = components[2];

        registrationPage.setDateOfBirth(day,month,year);

        logger.info("User set date of birth");
    }

    @And("User set {string} as email")
    public void userSetDynamicEmailAsEmail(String dynamicEmail) {
        dynamicEmail = email;
        registrationPage.enterEmail(dynamicEmail);

        logger.info("User set email");
    }

    @And("User set {string} as company details")
    public void userSetCompanyNameAsCompanyDetails(String company) throws InterruptedException {
        registrationPage.enterCompanyName(company);

        BasePage.Scroll_Down();

        logger.info("User set company details");
    }

    @And("User set Newsletter option as {string}")
    public void userSetNewsletterOptionAsStatus(String newsletter) {
        registrationPage.selectNewsletter(newsletter);

        logger.info("User set newsletter option");
    }

    @And("User set {string} as password and confirm password again")
    public void userSetPasswordAsPasswordAndConfirmPasswordAgain(String password) throws InterruptedException {
        registrationPage.setPassword(password,password);

        BasePage.Scroll_Down();

        logger.info("User set password and confirm password");
    }

    @And("User click on the Register button")
    public void userClickOnTheRegisterButton() {
        registrationPage.clickRegBtn();

        logger.info("User click on the Register button");
    }

    @Then("Verify that the new account registration message {string} is displayed")
    public void verifyThatTheNewAccountRegistrationMessageMsgIsDisplayed(String message) throws InterruptedException {
        BasePage.SmallWait(2000);

        Assert.assertEquals(message, registrationPage.verifyMessage());

        registrationPage.clickContinueBtn();

        logger.info("Verify that the new account registration message is displayed");

        quit = false;
        launch = false;
    }
}
