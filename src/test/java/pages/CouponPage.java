package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CouponPage extends BasePage {

    private By newCouponButton = By.cssSelector("a[class='btn btn-primary pull-right']");
    private By couponNameInput = By.id("name");
    private By discountAmountInput = By.id("discount_amount");
    private By validDateInput = By.cssSelector("input[placeholder='yyyy-mm-dd']");
    private By numberOfCouponsInput = By.id("number_coupons");
    private By submitButton = By.name("submit");
    private By addCouponSuccessAlert = By.cssSelector("div.alert-success");
    private By addCouponErrorAlert = By.cssSelector("div.alert-danger");

    private By searchCouponInput = By.cssSelector("input[placeholder='Coupon name']");
    private By foundCoupons = By.tagName("tr");

    private By deleteCouponIcon = By.cssSelector("a[class='btn btn-danger index-delete']");

    public CouponPage(WebDriver driver) {
        super(driver);
    }

    public void addCoupon(String couponName, String discountAmount, String validDate, String numberOfCoupons) {
        clickOn(newCouponButton);
        enterTextIn(couponNameInput, couponName);
        enterTextIn(discountAmountInput, discountAmount);
        enterTextIn(validDateInput, validDate);
        enterTextIn(numberOfCouponsInput, numberOfCoupons);
        clickOn(submitButton);
    }

    public void searchCoupon(String couponName) {
        enterTextIn(searchCouponInput, couponName + Keys.ENTER);
    }

    public void deleteCoupon(String couponName) {
        if(isCouponFound(couponName)) {
            clickOn(deleteCouponIcon);
        } else {
            Assert.fail("Coupon is not found!");
        }
    }

    public boolean isMessageContains(String text) {
        if(getAlertMessage().contains(text))
            return true;
        else return false;
    }

    public String getAlertMessage() {
        if(findElements(addCouponSuccessAlert).size() > 0) {
            return findElements(addCouponSuccessAlert).get(0).getText();
        } else if(findElements(addCouponErrorAlert).size() > 0) {
            return findElements(addCouponErrorAlert).get(0).getText();
        } else {
            return "Alert is not found!";
        }
    }

    public boolean isCouponFound(String couponName) {
        if(findElements(foundCoupons).size() > 0) {
            return true;
        } else return false;
    }
}
