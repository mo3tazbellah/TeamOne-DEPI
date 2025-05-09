package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    // driver
    WebDriver browser;
    // locators
    protected By usernameLocator = By.id("user-name");
    protected By passwordLocator = By.id("password");
    protected By clickBtnLocator = By.id("login-button");
    protected By messageLocator = By.xpath("//*[text()=\"Products\"]");
    protected By lockedOutMessageLocator = By.xpath("//*[text()=\"Sorry, this user has been locked out.\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    // constructor

    // methods
    public void loginAs(String username, String password){
       sendKeys(usernameLocator,username,5);
       sendKeys(passwordLocator,password,5);
    }

    public InventoryPage clickLoginBtn(){
        click(clickBtnLocator,5);
        return new InventoryPage(driver);
    }

    public String getMessage(){
        return getText(messageLocator);

    }

    public String getLockedOutMessage(){
        return getText(lockedOutMessageLocator);
    }
}
