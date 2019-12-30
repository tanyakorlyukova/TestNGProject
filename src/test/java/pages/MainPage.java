package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private By menu = By.cssSelector("span[class='caret']");
    private By logoutItem = By.xpath("//i[@class='glyphicon glyphglyphicon glyphicon-off']/ancestor::a");
    private By loginButton = By.cssSelector("a[class='btn btn-primary-white']");

    private By eShopItem = By.xpath("//div[@id='accordion']//div[1]//div[1]//h4[1]//a[1]");
    private By couponsItem = By.xpath("//div[@id='collapseOne']//tr[4]//td[1]//li[1]//a[1]");

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

    public CouponPage openCouponsPage() {
        driver.findElement(eShopItem).click();
        driver.findElement(couponsItem).click();

        return new CouponPage(driver);
    }
}
