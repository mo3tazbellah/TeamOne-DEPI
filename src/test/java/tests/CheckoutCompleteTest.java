package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;
import pages.CheckoutStepTwoPage;

public class CheckoutCompleteTest extends BaseTest {

    @Test
    public void checkoutCompleteTest() {
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.clickFinishButton();

        String actual = checkoutCompletePage.getAssertInFinishPage();
        String expected = "Finish";
        Assert.assertEquals(actual,expected);

        String actualThanksMassage = checkoutCompletePage.getAssertThanksMessage();
        String expectedThanksMassage = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actualThanksMassage,expectedThanksMassage);
    }
}

