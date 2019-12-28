package tests;

import org.testng.annotations.BeforeMethod;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void openLoginPage() {
        driver.get("http://open-eshop.stqa.ru/oc-panel/auth/login/");
    }
}
