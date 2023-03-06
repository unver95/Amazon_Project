package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBar extends ParentFunctions {
    public WebElement element;

    public NavBar() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "searchDropdownBox")
    private WebElement dropDownBox;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBar;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchBarButton;

    @FindBy(css = "[class='a-color-state a-text-bold']")
    private WebElement searchResult;

    public void waitUntilTextVisibleNB(String elementText) {
        element = creatElementByXpathWithContainsTextParent(elementText);
        waitUntilVisibleParent(element);
    }

    public void selectByVisibleTextNB(String elementText, String text) {
        switch (elementText) {
            case "dropDownBox":
                element = dropDownBox;
                break;
        }
        selectByVisibleTextParent(element, text);
    }

    public void sendKeysNB(String elementText, String text) {
        switch (elementText) {
            case "twotabsearchtextbox":
                element = searchBar;
                break;
        }
        sendKeysFunctionParent(element, text);
    }

    public void clickElementNB(String elementText) {
        switch (elementText) {
            case "searchBarButton":
                element = searchBarButton;
                break;
        }
        clickElementParent(element);
    }

    public void containsTextNB(String elementText, String text) {
        switch (elementText) {
            case "searchResult":
                element = searchResult;
                break;
        }
        waitUntilVisibleParent(element);
        verifyContainsTextParent(element, text);
    }
}