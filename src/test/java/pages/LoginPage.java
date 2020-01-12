package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends BasePage{

    private By emailField = By.cssSelector("section[id='page'] input[placeholder='Email']");
    private By passwordField = By.cssSelector("section[id='page'] input[placeholder='Password']");
    private By welcomeText = By.tagName("h1");
    private By errorAlert = By.cssSelector("section[id='page'] div[class='alert alert-danger']");
    private By errorLabel = By.cssSelector("label.error");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logIn(String email, String password) {
        enterTextIn(emailField, email);
        enterTextIn(passwordField,password + Keys.ENTER);
        return this;
    }

    public String getWelcomeText() {
        List<WebElement> welcome = findElements(welcomeText);
        if(welcome.size() == 1) {
            return welcome.get(0).getText();
        } else if (welcome.size() == 0){
            return "Welcome message was not found.";
        } else {
            return "Some errors in test.";
        }
    }

    public void waitForErrorAlertDisplayed() {
        waitForElementDisplayed(errorAlert);
    }

    public void waitForErrorLabelDisplayed() {
        waitForElementDisplayed(errorLabel);
    }

    public String getAlertErrorText() {
        return getText(errorAlert);
    }

    public String getLabelErrorText() {
        return getText(errorLabel);
    }

    public boolean isErrorContainsExpectedText(String expectedErrorText) {
        if(getAlertErrorText().contains(expectedErrorText)) {
            return true;
        } else
            return false;
    }
}
