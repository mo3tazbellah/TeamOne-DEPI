package data_driven;

import base.BaseTest;
import org.testng.annotations.DataProvider;

public class DataDriven extends BaseTest {


    @DataProvider(name = "CheckoutData")
    public Object[][] checkoutData() {
        return new Object[][]{
                {"standard_user", "secret_sauce","helana","emad","123"}
        };
    }

    @DataProvider(name = "CheckoutDataWithProblemUser")
    public Object[][] checkoutDataWithProblemUser() {
        return new Object[][]{
                {"standard_user", "secret_sauce","helana","emad","123"},
                {"problem_user", "secret_sauce","helana","emad","123"}
        };
    }
}
