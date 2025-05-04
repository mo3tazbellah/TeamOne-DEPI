package checkout_complete_test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;

public class CheckoutCompleteTest extends BaseTest {

    @Test
    public void checkoutCompleteTest() {
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        String actual = checkoutCompletePage.getAssertInFinishPage();
        String expected = "Finish";
        Assert.assertEquals(actual,expected);

        String actualThanksMassage = checkoutCompletePage.getAssertThanksMessage();
        String expectedThanksMassage = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actual,expected);
    }
}
