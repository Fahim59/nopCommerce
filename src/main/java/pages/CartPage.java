package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By termField = By.xpath("//input[@id='termsofservice']");
    private final By checkoutBtn = By.xpath("//button[@id='checkout']");

    public CartPage selectTermBtn(){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(termField));
        if (!element.isSelected()) {
            element.click();
        }
        return this;
    }
    public void clickCheckoutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }

    //----------------------------------------------------------------------------------------------------//

    private final By confirmBtn = By.xpath("//button[normalize-space()='Confirm']");

    private final By message = By.xpath("//h2[normalize-space()='Your order has been placed successfully']");

    public void clickConfirmBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
    }

    public String verifyProducts(String product){
        WebElement productText = driver.findElement(By.xpath("//a[normalize-space()='"+product+"']"));

        return productText.getText();
    }

    public String verifyMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
    }
}
