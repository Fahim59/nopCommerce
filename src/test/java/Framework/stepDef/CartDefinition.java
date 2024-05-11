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

public class CartDefinition {
    public WebDriver driver;
    private final CartPage cartPage;

    private static final Logger logger = LogManager.getLogger(CartDefinition.class);

    FileReader data;
    JSONObject products;

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public CartDefinition(TestContext context) {
        driver = context.driver;
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @And("User accept terms conditions and click checkout button")
    public void userAcceptTermsConditionsAndClickCheckoutButton() throws InterruptedException {
        BasePage.Scroll_Down();

        cartPage.selectTermBtn();
        cartPage.clickCheckoutBtn();

        logger.info("User accept terms conditions and click checkout button");
    }

    //-------------------------------------------------------------------------------------------------------------//

    @And("Place order successfully")
    public void placeOrderSuccessfully() throws FileNotFoundException {
        try {
            String file = "src/main/resources/data.json";
            data = new FileReader(file);

            JSONTokener tokener = new JSONTokener(data);
            products = new JSONObject(tokener);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        Assert.assertEquals(products.getJSONObject("products").getString("product1"),
                cartPage.verifyProducts(products.getJSONObject("products").getString("product1")));

        Assert.assertEquals(products.getJSONObject("products").getString("product2"),
                cartPage.verifyProducts(products.getJSONObject("products").getString("product2")));

        cartPage.clickConfirmBtn();

        logger.info("Place order successfully");
    }

    @Then("Go to the order details page and verify the order")
    public void goToTheOrderDetailsPageAndVerifyTheOrder() {
        Assert.assertEquals(products.getJSONObject("products").getString("message"), cartPage.verifyMessage());

        logger.info("Go to the order details page and verify the order");
    }
}
