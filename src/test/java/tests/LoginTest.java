package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;



public class LoginTest extends BaseTest {

    @Parameters({"username", "password"})
    @Test
    public void testLoginIsSuccessful(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);

        if (username.equals("locked_out_user")) {
            String actualMessage = loginPage.getLockedOutMessage();
            String expectedMessage = "Sorry, this user has been locked out.";
            Assert.assertTrue(actualMessage.contains(expectedMessage), "Locked out user message is not displayed as expected.");
            return;
        }

        String actualMessage = loginPage.getMessage();
        String expectedMessage = "Products";
        Assert.assertEquals(actualMessage, expectedMessage);


    }
}
