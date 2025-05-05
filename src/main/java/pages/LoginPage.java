package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public WebElement getMessage(){
        By messageLocator = By.tagName("h3");
        WebElement message = browser.findElement(messageLocator);

        return message;
    }
}
