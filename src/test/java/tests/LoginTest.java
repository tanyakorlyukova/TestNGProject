package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void openLoginPage() {
        driver.get("http://open-eshop.stqa.ru/oc-panel/auth/login/");
    }

    @Test
    public void correctLogIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn("demo@open-eshop.com", "demo");
    }

    @Test(dataProvider = "dataForIncorrectLogIn")
    public void incorrectLogIn(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(email, password);
    }

    @DataProvider(name = "dataForIncorrectLogIn")
    private Object[][] dataForIncorrectLogIn() {
        return new Object[][] {
                {"", ""},  //empty
                {"demo@open-eshop.com", "incorrectPassword"},   //incorrect password
                {"incorrectEmail@email.com", "demo"},        //incorrect email
                {"invalid Email", "password"}    //invalid email
        };
    }
}
