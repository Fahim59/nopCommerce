package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By regBtn = By.xpath("//a[normalize-space()='Register']");

    //private final By electronicsMenu = By.xpath("(//a[normalize-space()='Electronics'])[1]");

    //private final By cellPhoneMenu = By.xpath("(//a[normalize-space()='Cell phones'])[1]");

    public void clickRegBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(regBtn)).click();
    }

    public HomePage hoverOnElectronicsMenu(String menu){
        final By electronicsMenu = By.xpath("(//a[normalize-space()='"+menu+"'])[1]");

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(electronicsMenu));

        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        return this;
    }

    public HomePage clickCellPhoneMenu(String menu){
        final By cellPhoneMenu = By.xpath("(//a[normalize-space()='"+menu+"'])[1]");

        wait.until(ExpectedConditions.elementToBeClickable(cellPhoneMenu)).click();

        return this;
    }

    public HomePage clickCellPhoneOption(String menu1, String menu2){
        return hoverOnElectronicsMenu(menu1).clickCellPhoneMenu(menu2);
    }

    //----------------------------------------------------------------------------------------------------//
    private final By notificationBtn = By.xpath("//button[normalize-space()='No']");
    private final By closeBtn = By.xpath("//button[@aria-label='Close button']");

    private final By signInBtn = By.xpath("//span[text()='Sign in / Sign up']");

    private final By phoneField = By.xpath("//input[@name='phoneNumber']");
    private final By loginBtn = By.xpath("//button[normalize-space()='Login']");
    private final By otpField = By.xpath("//input[@id='otp']");
    private final By verifyBtn = By.xpath("//button[normalize-space()='Verify']");

    private final By searchField = By.xpath("//input[@id='autocomplete-0-input']");
    private final By addToBagBtn = By.xpath("//button[normalize-space()='Add to Bag']");

    private final By itemsBtn = By.xpath("//span[contains(text(),'items')]");

    private final By placeOrderBtn = By.xpath("//button[normalize-space()='Place order']");

    public void clickNotificationBtn(){
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationBtn));
        if(button.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        }
    }
    public void clickCloseBtn(){
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(closeBtn));
        if(button.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        }
    }

    public void clickSignInBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();
    }

    public HomePage enterPhoneNumber(String number){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(phoneField));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = arguments[1];", element, number);

        return this;
    }
    public HomePage clickLoginBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        return this;
    }
    public HomePage enterOtpNumber(String otp){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(otpField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(otp);
        } else {
            element.clear();
            element.sendKeys(otp);
        }
        return this;
    }
    public HomePage clickVerifyBtnBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(verifyBtn)).click();
        return this;
    }

    public HomePage setLoginDetails(String number,String otp) throws InterruptedException {
        return enterPhoneNumber(number).clickLoginBtn().enterOtpNumber(otp).clickVerifyBtnBtn();
    }

    public HomePage searchProduct(String product) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(searchField));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = '';", element);

        element.sendKeys(product);

        BasePage.SmallWait(1000);
        return this;
    }
    public HomePage clickAddToBagBtn() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(addToBagBtn));
        if(button.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        }
        return this;
    }

    public HomePage searchProduct(String product1,String product2) throws InterruptedException {
        return searchProduct(product1).clickAddToBagBtn().searchProduct(product2).clickAddToBagBtn();
    }

    public void clickItemsBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(itemsBtn)).click();
    }

    public void clickPlaceOrderBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }
}
