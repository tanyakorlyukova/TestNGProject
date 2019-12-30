package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private By menu = By.cssSelector("span[class='caret']");
    private By logoutItem = By.xpath("//i[@class='glyphicon glyphglyphicon glyphicon-off']/ancestor::a");
    private By loginButton = By.cssSelector("a[class='btn btn-primary-white']");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logOut() {
        driver.findElement(menu).click();
        driver.findElement(logoutItem).click();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
}
