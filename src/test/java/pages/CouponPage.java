package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CouponPage extends BasePage{

    private By newCouponButton = By.cssSelector("a[class='btn btn-primary pull-right']");
    private By couponNameInput = By.id("name");
    private By discountAmountInput = By.id("discount_amount");
    private By validDateInput = By.cssSelector("input[placeholder='yyyy-mm-dd']");
    private By numberOfCouponsInput = By.id("number_coupons");
    private By submitButton = By.name("submit");

    private By searchCouponInput = By.cssSelector("input[placeholder='Coupon name']");

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

    public void deleteCoupon() {
        clickOn(deleteCouponIcon);
    }

}
