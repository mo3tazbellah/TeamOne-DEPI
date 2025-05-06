package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    // driver
    WebDriver browser;
    // locators
    private By usernameLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By clickBtnLocator = By.id("login-button");
    private By messageLocator = By.tagName("h3");
    // constructor
    public LoginPage(WebDriver driver){
        this.browser = driver;
    }
    // methods
    public InventoryPage loginAs(String username, String password, WebDriver driver){
        browser.findElement(usernameLocator).sendKeys(username);
        browser.findElement(passwordLocator).sendKeys(password);
        browser.findElement(clickBtnLocator).click();
        return new InventoryPage(driver);
    }
    public String getMessage(){
        String message = browser.findElement(messageLocator).getText();
        return message;
    }
}
