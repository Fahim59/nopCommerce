package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CellPhonePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CellPhonePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By allProducts = By.xpath("(//h2[@class='product-title'])");
    private final By cartBtn = By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])");

    private final By quantityBox = By.xpath("//input[@id='product_enteredQuantity_20']");
    private final By addToCartBtn = By.xpath("(//button[@type='button'][text()='Add to cart'])[1]");
    private final By closeBtn = By.xpath("//span[@title='Close']");

    private final By shoppingCart = By.xpath("//span[@class='cart-label']");

    public int getProductsCount() {
        List<WebElement> elements = driver.findElements(allProducts);
        return elements.size();
    }

    public CellPhonePage clickProduct(String product){
        for(int i = 0; i < getProductsCount(); i++){
            String productName = driver.findElements(allProducts).get(i).getText();

            if(productName.equalsIgnoreCase(product)){
                //driver.findElements(cartBtn).get(i).click();

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@class='product-title']//a[contains(text(),'"+product+"')]"))).click();
                break;
            }
        }

        return this;
    }

    public CellPhonePage enterQuantity(String quantity){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(quantityBox));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(quantity);
        } else {
            element.clear();
            element.sendKeys(quantity);
        }
        return this;
    }
    public void clickAddToCartBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
    public void clickCloseBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
    }

    public void clickShoppingCartBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart)).click();
    }
}
