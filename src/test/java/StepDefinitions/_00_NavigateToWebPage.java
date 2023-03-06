package StepDefinitions;

import Pages.NavBar;
import Utilities.GWD;
import io.cucumber.java.en.Given;

public class _00_NavigateToWebPage {
    NavBar nb = new NavBar();
    @Given("the user is on the website")
    public void theUserIsOnTheWebsite() {
        GWD.getDriver().manage().window().maximize();
        GWD.getDriver().get("https://www.amazon.com/");
        nb.waitUntilTextVisibleNB("Hello");

    }
}
