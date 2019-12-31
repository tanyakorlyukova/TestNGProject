package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {

    private By emailField = By.cssSelector("section[id='page'] input[placeholder='Email']");
    private By passwordField = By.cssSelector("section[id='page'] input[placeholder='Password']");
    private By welcomeText = By.tagName("h21");
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
        List<WebElement> welcome = driver.findElements(welcomeText);
        if(welcome.size() == 1) {
            return welcome.get(0).getText();
        } else if (welcome.size() == 0){
            return "Welcome message was not found. Probably, user was not logged in.";
        } else {
            return "Some errors in test.";
        }
    }

    public void waitForErrorAlertDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorAlert)));
    }

    public String getErrorText() {
        return driver.findElement(errorAlert).getText();
    }

    public boolean isErrorContainsExpectedText(String expectedErrorText) {
        if(getErrorText().contains(expectedErrorText)) {
            return true;
        }
        else return false;
    }
}
