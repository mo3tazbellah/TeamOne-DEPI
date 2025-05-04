package checkout_step_one_test;
import base.BaseTest;
import data_driven.DataDriven;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckoutStepOnePage;

public class CheckoutStepOneTest extends BaseTest {

    @Test(dataProvider = "CheckoutData", dataProviderClass = DataDriven.class)
    public void checkoutStepTwoTestWithValidDetails(String firstName,String lastName,String postalCode){
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);

        SoftAssert softAssert = new SoftAssert();
        String actual = checkoutStepOnePage.getAssertInCheckOutStepOnePage();
        String expected = "Checkout: Your Information";
        softAssert.assertEquals(actual,expected);

        checkoutStepOnePage.enterDetails(firstName,lastName,postalCode);

        checkoutStepOnePage.clickContinueButton();

        softAssert.assertAll();

    }
}
