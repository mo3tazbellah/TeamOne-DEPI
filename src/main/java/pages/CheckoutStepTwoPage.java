package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CheckoutStepTwoPage extends MethodHandles {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

  protected By assertInCheckOutStepTwoPage=By.xpath("//*[text()=\"Checkout: Overview\"]");
    protected By productOne=By.xpath("//*[text()=\"Sauce Labs Backpack\"]");
    protected By productOnePrice=By.xpath("//*[text()=\"29.99\"]");

    protected By productTwo=By.xpath("//*[text()=\"Sauce Labs Bike Light\"]");
    protected By productTwoPrice=By.xpath("//*[text()=\"9.99\"]");

    protected By productThree=By.xpath("//*[text()=\"Sauce Labs Fleece Jacket\"]");
    protected By productThreePrice=By.xpath("//*[text()=\"49.99\"]");

    protected By tax=By.xpath("//*[text()=\"Tax: $7.20\"]");
    protected By fishButton=By.xpath("//*[text()=\"FINISH\"]");

    public String getAssertInCheckOutStepTwoPage() {
        return getText(assertInCheckOutStepTwoPage);
    }

    public String getProductOne() {
        return getText(productOne);
    }

    public String getProductOnePrice() {
        return getText(productOnePrice);
    }

    public String getProductTwo() {
        return getText(productTwo);
    }

    public String getProductTwoPrice() {
        return getText(productTwoPrice);
    }

    public String getProductThree() {
        return getText(productThree);
    }

    public String getProductThreePrice() {
        return getText(productThreePrice);
    }


    public double totalPrice() {
        return Double.parseDouble(getProductOnePrice())+Double.parseDouble(getProductTwoPrice())+Double.parseDouble(getProductThreePrice());
    }

    public CheckoutCompletePage clickFinishButton() {
        click(fishButton,5);
        return new CheckoutCompletePage(driver);
    }

}
