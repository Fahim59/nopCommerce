package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By checkoutGuestBtn = By.xpath("//button[normalize-space()='Checkout as Guest']");

    private final By firstNameField = By.xpath("//input[@id='BillingNewAddress_FirstName']");
    private final By lastNameField = By.xpath("//input[@id='BillingNewAddress_LastName']");
    private final By emailField = By.xpath("//input[@id='BillingNewAddress_Email']");
    private final By companyField = By.xpath("//input[@id='BillingNewAddress_Company']");
    private final By countryField = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    private final By cityField = By.xpath("//input[@id='BillingNewAddress_City']");
    private final By address1Field = By.xpath("//input[@id='BillingNewAddress_Address1']");
    private final By zipField = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    private final By phoneField = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");

    private final By continueBillingBtn = By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']");

    private final By shippingOption = By.xpath("//input[@id='shippingoption_1']");
    private final By continueShippingBtn = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");

    private final By paymentOption = By.xpath("//input[@id='paymentmethod_1']");
    private final By continuePaymentBtn = By.xpath("//button[@class='button-1 payment-method-next-step-button']");

    private final By cardHolderNameField = By.xpath("//input[@id='CardholderName']");
    private final By cardNumberField = By.xpath("//input[@id='CardNumber']");
    private final By cardCodeField = By.xpath("//input[@id='CardCode']");
    private final By expireYearField = By.xpath("//select[@id='ExpireYear']");
    private final By continuePaymentInfoBtn = By.xpath("//button[@class='button-1 payment-info-next-step-button']");

    private final By continueBtn = By.xpath("//button[normalize-space()='Confirm']");

    private final By message = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");

    public void clickCheckoutGuestBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutGuestBtn)).click();
    }

    public CheckoutPage enterFirstName(String firstName){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(firstNameField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(firstName);
        } else {
            element.clear();
            element.sendKeys(firstName);
        }
        return this;
    }
    public CheckoutPage enterLastName(String lastName){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(lastNameField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(lastName);
        } else {
            element.clear();
            element.sendKeys(lastName);
        }
        return this;
    }
    public CheckoutPage enterEmail(String email){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(email);
        } else {
            element.clear();
            element.sendKeys(email);
        }
        return this;
    }
    public CheckoutPage enterCompanyName(String company){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(companyField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(company);
        } else {
            element.clear();
            element.sendKeys(company);
        }
        return this;
    }
    public CheckoutPage selectCountry(String country){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(countryField));

        Select select = new Select(element);
        select.selectByVisibleText(country);

        return this;
    }
    public CheckoutPage enterCity(String city){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(cityField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(city);
        } else {
            element.clear();
            element.sendKeys(city);
        }
        return this;
    }
    public CheckoutPage enterAddress(String address){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(address1Field));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(address);
        } else {
            element.clear();
            element.sendKeys(address);
        }
        return this;
    }
    public CheckoutPage enterZip(String zip){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(zipField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(zip);
        } else {
            element.clear();
            element.sendKeys(zip);
        }
        return this;
    }
    public CheckoutPage enterPhone(String phone){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(phoneField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(phone);
        } else {
            element.clear();
            element.sendKeys(phone);
        }
        return this;
    }

    public CheckoutPage setBilingDetails(String firstName,String lastName,String email,String company,String country
                                 ,String city,String address,String zip,String phone){

        return enterFirstName(firstName).enterLastName(lastName).enterEmail(email).enterCompanyName(company).
                selectCountry(country).enterCity(city).enterAddress(address).enterZip(zip).enterPhone(phone);
    }
    public void clickContinueBillingBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(continueBillingBtn)).click();
    }

    public CheckoutPage selectShippingOption(){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(shippingOption));
        if (!element.isSelected()) {
            element.click();
        }
        return this;
    }
    public void clickShippingBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShippingBtn)).click();
    }

    public CheckoutPage selectPaymentOption(){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(paymentOption));
        if (!element.isSelected()) {
            element.click();
        }
        return this;
    }
    public void clickPaymentBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentBtn)).click();
    }

    public CheckoutPage enterCardHolderName(String name){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(cardHolderNameField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(name);
        } else {
            element.clear();
            element.sendKeys(name);
        }
        return this;
    }
    public CheckoutPage enterCardNumber(String number){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(cardNumberField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(number);
        } else {
            element.clear();
            element.sendKeys(number);
        }
        return this;
    }
    public CheckoutPage enterCardCode(String code){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(cardCodeField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(code);
        } else {
            element.clear();
            element.sendKeys(code);
        }
        return this;
    }
    public CheckoutPage selectExpireYear(String year){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(expireYearField));

        Select select = new Select(element);
        select.selectByVisibleText(year);

        return this;
    }

    public CheckoutPage setPaymentDetails(String name,String number,String code,String year){
        return enterCardHolderName(name).enterCardNumber(number).enterCardCode(code).selectExpireYear(year);
    }
    public void clickPaymentInfoBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentInfoBtn)).click();
    }

    public void clickContinueBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public String verifyMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
    }
}
