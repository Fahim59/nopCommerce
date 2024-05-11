package Framework.stepDef;

import context.TestContext;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckoutDefinition extends BasePage{
    public WebDriver driver;
    private final CheckoutPage checkoutPage;

    private static final Logger logger = LogManager.getLogger(CheckoutDefinition.class);

    FileReader data;
    JSONObject billingDetails, cardDetails;

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public CheckoutDefinition(TestContext context) {
        driver = context.driver;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @And("User click checkout as guest button")
    public void userClickCheckoutAsGuestButton() throws InterruptedException {
        checkoutPage.clickCheckoutGuestBtn();

        BasePage.SmallWait(2000);

        logger.info("User click checkout as guest button");
    }

    @And("User input all the billing details and click continue")
    public void userInputAllTheBillingDetailsAndClickContinue() throws InterruptedException, FileNotFoundException {
        try {
            String file = "src/main/resources/data.json";
            data = new FileReader(file);

            JSONTokener tokener = new JSONTokener(data);
            billingDetails = new JSONObject(tokener);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        checkoutPage.setBilingDetails(billingDetails.getJSONObject("billingDetails").getString("firstName"),
                billingDetails.getJSONObject("billingDetails").getString("lastName"),
                billingDetails.getJSONObject("billingDetails").getString("email"),
                billingDetails.getJSONObject("billingDetails").getString("company"),
                billingDetails.getJSONObject("billingDetails").getString("country"),
                billingDetails.getJSONObject("billingDetails").getString("city"),
                billingDetails.getJSONObject("billingDetails").getString("address"),
                billingDetails.getJSONObject("billingDetails").getString("zip"),
                billingDetails.getJSONObject("billingDetails").getString("phone"));

        BasePage.Scroll_Down();

        checkoutPage.clickContinueBillingBtn();

        BasePage.SmallWait(2000);

        logger.info("User input all the billing details and click continue");
    }

    @And("User select shipping method {string} and click continue")
    public void userSelectShippingMethodAndClickContinue(String method) throws InterruptedException {
        checkoutPage.selectShippingOption();
        checkoutPage.clickShippingBtn();

        BasePage.SmallWait(2000);

        logger.info("User select shipping method "+method+ " and click continue");
    }

    @And("User select payment method {string} and click continue")
    public void userSelectPaymentMethodAndClickContinue(String method) throws InterruptedException {
        checkoutPage.selectPaymentOption();
        checkoutPage.clickPaymentBtn();

        BasePage.SmallWait(2000);

        logger.info("User select payment method "+method+ " and click continue");
    }

    @And("User select {string} card and input card information")
    public void userSelectCardAndInputCardInformation(String card) throws InterruptedException, FileNotFoundException {
        try {
            String file = "src/main/resources/data.json";
            data = new FileReader(file);

            JSONTokener tokener = new JSONTokener(data);
            cardDetails = new JSONObject(tokener);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        checkoutPage.setPaymentDetails(cardDetails.getJSONObject("cardInfo").getString("name"),
                cardDetails.getJSONObject("cardInfo").getString("number"),
                cardDetails.getJSONObject("cardInfo").getString("code"),
                cardDetails.getJSONObject("cardInfo").getString("year"));

        checkoutPage.clickPaymentInfoBtn();
        
        BasePage.Scroll_Down();

        BasePage.SmallWait(2000);

        logger.info("User select "+card+ " card and input card information");
    }

    @And("User click confirm button to place the order")
    public void userClickConfirmButtonToPlaceTheOrder() throws InterruptedException {
        checkoutPage.clickContinueBtn();

        BasePage.SmallWait(2000);

        logger.info("User click confirm button to place the order");
    }

    @Then("Verify that the order place message {string} is displayed")
    public void verifyThatTheOrderPlaceMessageIsDisplayed(String message) {
        Assert.assertEquals(message, checkoutPage.verifyMessage());

        quit = true;
        launch = true;

        logger.info("User that the order place message " +message+ " is displayed");
    }
}
