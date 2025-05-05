package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver browser;

    public LoginPage(WebDriver driver){
        this.browser = driver;
    }

    public InventoryPage loginAs(String username, String password, WebDriver driver){
        By usernameLocator = By.id("user-name");
        By passwordLocator = By.id("password");
        By clickBtnLocator = By.id("login-button");

        browser.findElement(usernameLocator).sendKeys(username);
        browser.findElement(passwordLocator).sendKeys(password);
        browser.findElement(clickBtnLocator).click();

        return new InventoryPage(driver);
    }

}
