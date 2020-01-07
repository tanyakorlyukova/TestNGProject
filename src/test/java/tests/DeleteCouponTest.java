package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CouponPage;
import pages.MainPage;

public class DeleteCouponTest extends BaseTest {

    String couponName = "Coupon" + Math.random()*1000;

    @BeforeMethod
    public void addAndSearchCoupon(){
        MainPage mainPage = new MainPage(driver);
        CouponPage couponPage = mainPage.openCouponsPage();
        couponPage.addCoupon(couponName, "5", "2020-01-23", "6");
        couponPage.searchCoupon(couponName);
    }

    @Test
    public void deleteCoupon() {
        MainPage mainPage = new MainPage(driver);
        CouponPage couponPage = mainPage.openCouponsPage();
        couponPage.deleteCoupon();

        couponPage.searchCoupon(couponName);
        Assert.assertFalse(couponPage.isCouponFound(couponName));

    }

}
