package Framework.stepDef;

import context.TestContext;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import pages.*;

public class CellPhoneDefinition {
    public WebDriver driver;
    private final CellPhonePage cellPhonePage;

    private static final Logger logger = LogManager.getLogger(CellPhoneDefinition.class);

    public static void main(String[] args) { Configurator.initialize(null, "log4j2.xml"); }

    public CellPhoneDefinition(TestContext context) {
        driver = context.driver;
        cellPhonePage = PageFactoryManager.getCellPhonePage(context.driver);
    }

    @And("User click on the {string} for product details")
    public void userClickOnTheForProductDetails(String product) throws InterruptedException {
        cellPhonePage.clickProduct(product);

        BasePage.Scroll_Down();

        logger.info("User click on the " +product+ " for product details");
    }

    @And("User set the quantity number {int} in the quantity field")
    public void userSetTheQuantityNumberInTheQuantityField(int quantity) {
        cellPhonePage.enterQuantity(String.valueOf(quantity));

        logger.info("User set the quantity number " +quantity+ " in the quantity field");
    }

    @And("User click on the {string} button")
    public void userClickOnTheButton(String button) throws InterruptedException {
        cellPhonePage.clickAddToCartBtn();

        //BasePage.SmallWait(6000);
        BasePage.SmallWait(1500);
        cellPhonePage.clickCloseBtn();

        logger.info("User click on the " +button+ " button");
    }

    @And("User go to the shipping cart page")
    public void userGoToTheShippingCartPage() throws InterruptedException {
        BasePage.SmallWait(1500);

        cellPhonePage.clickShoppingCartBtn();

        logger.info("User go to the shipping cart page");
    }
}
