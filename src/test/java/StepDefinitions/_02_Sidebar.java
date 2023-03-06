package StepDefinitions;

import Pages.ParentFunctions;
import Pages.Sidebar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _02_Sidebar {
    Sidebar sb = new Sidebar();
    ParentFunctions pf = new ParentFunctions();
    @When("The user clicks on all of the {string} options from the sidebar")
    public void theUserClicksOnAllOfTheOptionsFromTheSidebar(String option) {
        List<WebElement> options = sb.createElementByXPathSB(option);
        for(WebElement e : options){
            pf.clickElementParent(e);
            break;
        }
    }

    @Then("the user can see the link has changed")
    public void theUserCanSeeTheLinkHasChanged() {
    }

    @And("the user can go back")
    public void theUserCanGoBack() {
    }
}
