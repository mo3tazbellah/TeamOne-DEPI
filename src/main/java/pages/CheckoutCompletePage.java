package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CheckoutCompletePage extends MethodHandles {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }


    private final By assertInFinishPage=By.xpath("//*[text()=\"Finish\"]");
    private final By assertThanksMessage=By.xpath("//*[text()=\"THANK YOU FOR YOUR ORDER\"]");

    public String getAssertInFinishPage() {
        return getText(assertInFinishPage);
    }

    public String getAssertThanksMessage() {
        return getText(assertThanksMessage);
    }



}