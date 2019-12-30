package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private By emailField = By.cssSelector("section[id='page'] input[placeholder='Email']");
    private By passwordField = By.cssSelector("section[id='page'] input[placeholder='Password']");
    private By welcomeText = By.tagName("h1");
    private By errorAlert = By.cssSelector("section[id='page'] div[class='alert alert-danger']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password + Keys.ENTER);
    }

    public String getWelcomeText() {
        return driver.findElement(welcomeText).getText();
    }

    public void waitForErrorAlertDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorAlert)));
    }

    private String getErrorText() {
        return driver.findElement(errorAlert).getText();
    }

    public boolean isErrorContainsExpectedText(String expectedErrorText) {
        if(getErrorText().contains(expectedErrorText)) {
            return true;
        }
        else return false;
    }
}
