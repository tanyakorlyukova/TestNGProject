package pages;

import com.sun.tools.javac.util.Convert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void clickOn(By locator) {
        find(locator).click();
    }

    protected void enterTextIn(By locator, String text) {
        find(locator).sendKeys(text);
    }
}