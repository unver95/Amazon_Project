package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Sidebar extends ParentFunctions {
    WebElement element;
    List<WebElement> elements;

    public Sidebar() {
        PageFactory.initElements(GWD.getDriver(), this);
    }


    public List<WebElement> createElementByXPathSB(String text) {
        elements = GWD.getDriver().findElements(By.xpath("(//*[text()='" + text + "']//ancestor::div)[7]/ul//li"));
        return elements;
    }

    public void clickOnElementsSB(List<WebElement> elements){

    }
}
