package pages;

import factory.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import utils.ConfigLoader;

public class BasePage {

    public static boolean launch = true;
    public static boolean quit = false;

    public static void Open_Website(String endPoint){
        DriverFactory.getDriver().get(new ConfigLoader().initializeProperty().getProperty("baseUrl") +endPoint);
    }

    public static void SmallWait(int second) throws InterruptedException {Thread.sleep(second);}

    public static void Scroll_Down() throws InterruptedException {
        SmallWait(1000);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("window.scrollBy(0,450)", "");
    }
}
