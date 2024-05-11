package Framework.stepDef;

import context.TestContext;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class HomeDefinition {
    public WebDriver driver;
    private final HomePage homePage;

    private static final Logger logger = LogManager.getLogger(HomeDefinition.class);

    FileReader data;
    JSONObject products;

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public HomeDefinition(TestContext context) {
        driver = context.driver;
        homePage = PageFactoryManager.getHomePage(context.driver);
    }

    @Given("User go to the NopCommerce Home page")
    public void userGoToTheNopCommerceHomePage() {
        BasePage.Open_Website("");

        logger.info("User go to the NopCommerce Home page");
    }

    @And("User navigate to the Registration page")
    public void userNavigateToTheRegistrationPage() {
        homePage.clickRegBtn();

        logger.info("User navigate to the Registration page");
    }

    @When("User click {string} option from {string} category")
    public void userClickOptionFromCategory(String childMenu, String parentMenu) throws InterruptedException {
        homePage.clickCellPhoneOption(parentMenu,childMenu);

        BasePage.Scroll_Down();

        logger.info("User click " +childMenu+ " option from " +parentMenu+ " category");
    }

    //-------------------------------------------------------------------------------------------------------------//

    @Given("Go to the home page")
    public void goToTheHomePage() throws InterruptedException {
        BasePage.Open_Website("");

        homePage.clickNotificationBtn();

        BasePage.SmallWait(1500);

        logger.info("User go to the NopCommerce Home page");
    }

    @When("Login to the site")
    public void loginToTheSite() throws InterruptedException {
        homePage.clickSignInBtn();

        homePage.setLoginDetails("1755423542","12345");

        logger.info("Login to the site");
    }

    @And("Search two product from test data file and add to the shopping cart")
    public void searchTwoProductFromTestDataFileAndAddToTheShoppingCart() throws FileNotFoundException, InterruptedException {
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

        homePage.searchProduct(products.getJSONObject("products").getString("product1"),
                products.getJSONObject("products").getString("product2"));

        //homePage.clickCloseBtn();

        logger.info("Search two product from test data file and add to the shopping cart");
    }

    @And("Go to shopping cart and checkout")
    public void goToShoppingCartAndCheckout() throws InterruptedException {
        homePage.clickItemsBtn();
        homePage.clickPlaceOrderBtn();

        BasePage.SmallWait(1500);

        logger.info("Go to shopping cart and checkout");
    }
}
