package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.CheckoutStepOnePage;

public class CheckoutStepOneTest extends BaseTest {

    @Test(dataProvider = "CheckoutData", dataProviderClass = DataDriven.class)
    public void checkoutStepTwoTestWithValidDetails(String firstName,String lastName,String postalCode){
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOnePage = cartPage.clickCheckout(driver);

        String actual = checkoutStepOnePage.getAssertInCheckOutStepOnePage();
        String expected = "Checkout: Your Information";
        Assert.assertEquals(actual,expected);

        checkoutStepOnePage.enterDetails(firstName,lastName,postalCode);



        String actualFirstName = checkoutStepOnePage.getFirstNameValue();
        String actualLastName = checkoutStepOnePage.getLastNameValue();

        if (actualFirstName.equals(actualLastName)) {
           Assert.assertNotEquals(actualFirstName,actualLastName);
        }


    }
}
