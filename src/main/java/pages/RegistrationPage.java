package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By genderField = By.xpath("//input[@name='Gender']");

    private final By firstNameField = By.xpath("//input[@id='FirstName']");
    private final By lastNameField = By.xpath("//input[@id='LastName']");

    private final By dateField = By.xpath("//select[@name='DateOfBirthDay']");
    private final By monthField = By.xpath("//select[@name='DateOfBirthMonth']");
    private final By yearField = By.xpath("//select[@name='DateOfBirthYear']");

    private final By emailField = By.xpath("//input[@id='Email']");

    private final By companyField = By.xpath("//input[@id='Company']");

    private final By newsletterField = By.xpath("//input[@id='Newsletter']");

    private final By passwordField = By.xpath("//input[@id='Password']");
    private final By confirmPasswordField = By.xpath("//input[@id='ConfirmPassword']");

    private final By regBtn = By.xpath("//button[@id='register-button']");

    private final By message = By.xpath("//div[@class='result']");

    private final By continueBtn = By.xpath("//a[normalize-space()='Continue']");

    public void selectGender(String value){
        List<WebElement> options = driver.findElements(genderField);

        for (WebElement option : options) {
            if (option.getAttribute("value").equalsIgnoreCase(value)) {
                if (!option.isSelected()) {
                    option.click();
                }
            }
        }
    }

    public RegistrationPage enterFirstName(String firstName){
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
    public RegistrationPage enterLastName(String lastName){
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

    public RegistrationPage setFullName(String firstName,String lastName){
        return enterFirstName(firstName).enterLastName(lastName);
    }

    public RegistrationPage selectDate(String date){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));

        Select select = new Select(element);
        select.selectByVisibleText(date);

        return this;
    }
    public RegistrationPage selectMonth(String month){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(monthField));

        Select select = new Select(element);

        if(month.equals("01")){
            select.selectByVisibleText("January");
        }
        else if(month.equals("02")){
            select.selectByVisibleText("February");
        }
        else if(month.equals("03")){
            select.selectByVisibleText("March");
        }
        else if(month.equals("04")){
            select.selectByVisibleText("April");
        }
        else if(month.equals("05")){
            select.selectByVisibleText("May");
        }
        else if(month.equals("06")){
            select.selectByVisibleText("June");
        }
        else if(month.equals("07")){
            select.selectByVisibleText("July");
        }
        else if(month.equals("08")){
            select.selectByVisibleText("August");
        }
        else if(month.equals("09")){
            select.selectByVisibleText("September");
        }
        else if(month.equals("10")){
            select.selectByVisibleText("October");
        }
        else if(month.equals("11")){
            select.selectByVisibleText("November");
        }
        else if(month.equals("12")){
            select.selectByVisibleText("December");
        }

        return this;
    }
    public RegistrationPage selectYear(String year){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(yearField));

        Select select = new Select(element);
        select.selectByVisibleText(year);

        return this;
    }

    public RegistrationPage setDateOfBirth(String date,String month, String year){
        return selectDate(date).selectMonth(month).selectYear(year);
    }

    public RegistrationPage enterEmail(String email){
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

    public RegistrationPage enterCompanyName(String company){
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

    public RegistrationPage selectNewsletter(String value){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(newsletterField));
        if(value.equals("unchecked")){
            element.click();
        }
        return this;
    }

    public RegistrationPage enterPassword(String password){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(password);
        } else {
            element.clear();
            element.sendKeys(password);
        }
        return this;
    }
    public RegistrationPage enterConfirmPassword(String confirmPassword){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(confirmPasswordField));
        String text = element.getAttribute("value");

        if (text.isEmpty()) {
            element.sendKeys(confirmPassword);
        } else {
            element.clear();
            element.sendKeys(confirmPassword);
        }
        return this;
    }

    public RegistrationPage setPassword(String password,String confirmPassword){
        return enterPassword(password).enterConfirmPassword(confirmPassword);
    }

    public void clickRegBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(regBtn)).click();
    }

    public String verifyMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
    }

    public void clickContinueBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }
}
