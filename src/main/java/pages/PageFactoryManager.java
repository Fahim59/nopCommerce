package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static RegistrationPage registrationPage;
    private static HomePage homePage;
    private static CellPhonePage cellPhonePage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;

    public static RegistrationPage getRegistrationPage(WebDriver driver){
        return registrationPage == null ? new RegistrationPage(driver) : registrationPage;
    }

    public static HomePage getHomePage(WebDriver driver){
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static CellPhonePage getCellPhonePage(WebDriver driver){
        return cellPhonePage == null ? new CellPhonePage(driver) : cellPhonePage;
    }

    public static CartPage getCartPage(WebDriver driver){
        return cartPage == null ? new CartPage(driver) : cartPage;
    }

    public static CheckoutPage getCheckoutPage(WebDriver driver){
        return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
    }
}
