package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By emailField = By.cssSelector("section[id='page'] input[placeholder='Email']");
    private By passwordField = By.cssSelector("section[id='page'] input[placeholder='Password']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password + Keys.ENTER);
    }
}
