package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LoginPage;

public class BaseTest {
    protected static WebDriver driver;

    @Parameters({"username", "password"})
    @BeforeTest
    public void setUp(@Optional("standard_user") String username,
                      @Optional("secret_sauce") String password) {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }


        driver.get("https://www.saucedemo.com/v1/index.html");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(username, password);
        loginPage.clickLoginBtn();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
