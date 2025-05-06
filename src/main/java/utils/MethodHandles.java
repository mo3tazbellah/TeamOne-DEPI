package utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MethodHandles {
    protected WebDriver driver;

    private WebDriverWait wait;
    Select select;
    Actions actions;

    public MethodHandles(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement webElement(By locator) {
        return driver.findElement(locator);
    }

    private static String getMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 2) {
            if (stackTraceElements.length >= 4)
                return stackTraceElements[4].getMethodName();
            return stackTraceElements[2].getMethodName();
        } else {
            return "Unknown";
        }
    }



    private static void addBorderToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '7px solid red'", element);
    }

    protected void visiblityOfElement(By locator , int time)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void explicitWait(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)));
    }

    protected void invisibilityOf(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOf(webElement(locator)),
                ExpectedConditions.invisibilityOfElementLocated(locator)));
    }

    protected void selectByVisibleText(By locator, int time, String text) {
        select = new Select(webElement(locator));
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);

                addBorderToElement(driver, webElement(locator));
                select.selectByVisibleText(text);
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void selectByValue(By locator, int time, String value) {
        select = new Select(webElement(locator));
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);

                addBorderToElement(driver, webElement(locator));
                select.selectByValue(value);
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void selectByIndex(By locator, int time, int index) {
        select = new Select(webElement(locator));
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                select.selectByIndex(index);
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }


    protected void click(By locator, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                webElement(locator).click();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void submit(By locator, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                webElement(locator).submit();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected Point getLocation(By locator, int time) {
        Point point = null;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                point = webElement(locator).getLocation();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return point;
    }

    protected void clear(By locator, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                webElement(locator).clear();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected boolean isDisplayed(By locator, int time) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                flag = webElement(locator).isDisplayed();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return flag;
    }

    protected boolean isSelected(By locator, int time) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                flag = webElement(locator).isSelected();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return flag;
    }



    protected String getText(By locator) {
        String text = null;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, 5);

                addBorderToElement(driver, webElement(locator));
                text = webElement(locator).getText();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return text;
    }

    protected void sendKeys(By locator, String text, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                webElement(locator).sendKeys(text);
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    protected void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    protected void sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    protected void getTextAlert() {
        driver.switchTo().alert().getText();
    }

    protected void switchToFrame(String nameOrID) {
        driver.switchTo().frame(nameOrID);
    }

    protected void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    protected void switchToParent() {
        driver.switchTo().parentFrame();
    }

    protected void clickWithActions(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                actions.click(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void doubleClick(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                addBorderToElement(driver, webElement(locator));
                actions.doubleClick(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void contextClick(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);

                addBorderToElement(driver, webElement(locator));
                actions.contextClick(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }



}