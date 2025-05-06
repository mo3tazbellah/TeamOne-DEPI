package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CheckoutStepOnePage extends MethodHandles {
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    private By assertInCheckOutStepOnePage=By.xpath("//*[text()=\"Checkout: Your Information\"]");
    private By firstName=By.xpath("//input[@id='first-name']");
    private By lastName=By.xpath("//input[@id='last-name']");
    private By postalCode=By.xpath("//input[@id='postal-code']");
    private By continueButton=By.xpath("//input[@value='CONTINUE']");


    public String getAssertInCheckOutStepOnePage() {
        return getText(assertInCheckOutStepOnePage);
    }

    public void enterDetails(String firstName,String lastName,String postalCode){
        sendKeys(this.firstName,firstName,5);
        sendKeys(this.lastName,lastName,5);
        sendKeys(this.postalCode,postalCode,5);

    }

    public CheckoutStepTwoPage clickContinueButton(){
        click(continueButton,5);
        return new CheckoutStepTwoPage(driver);
    }

}