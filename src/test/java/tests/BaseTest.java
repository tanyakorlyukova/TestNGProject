package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    WebDriver driver;

    @BeforeClass
    public void initializeBrowsers() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void killBrowser() {
        driver.quit();
    }
}
