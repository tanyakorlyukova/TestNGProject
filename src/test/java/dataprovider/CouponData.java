package dataprovider;

import org.testng.annotations.DataProvider;

public class CouponData {

    @DataProvider(name = "correctCouponData")
    private Object[][] correctCouponData() {
        return new Object[][] {
                {"Name838", "1231", "2020-01-23", "3"}
        };
    }

    @DataProvider(name = "incorrectCouponData")
    private Object[][] incorrectCouponData() {
        return new Object[][] {
                {"Name838", "1231", "2020-01-23", "3", "not created, errors: coupon/coupon.name.unique"}
        };
    }
}
