package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class ParentFunctions {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    Assertion assertion = new Assertion();


    public void scrollToElementParent(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilVisibleParent(WebElement element) {    //! This is our explicitly wait
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickableParent(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void sendKeysFunctionParent(WebElement element, String value) {
        waitUntilVisibleParent(element);
        scrollToElementParent(element);
        element.clear();
        element.sendKeys(value);
    }

    public void selectByVisibleTextParent(WebElement element, String text) {
        scrollToElementParent(element);
        // waitUntilClickableParent(element); because it is a select we cant use waitUntilClickable
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void clickElementParent(WebElement element) {
        waitUntilClickableParent(element);
        scrollToElementParent(element);
        element.click();
    }

    public WebElement creatElementByXpathWithContainsTextParent(String elementText) {
        return GWD.getDriver().findElement(By.xpath("//*[contains(text(),'" + elementText + "')]"));
    }

    public void verifyContainsTextParent(WebElement element, String text) {
        waitUntilVisibleParent(element);
        scrollToElementParent(element);
        assertion.assertTrue(element.getText().contains(text));
    }
}