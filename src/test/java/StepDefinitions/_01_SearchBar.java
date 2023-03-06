package StepDefinitions;

import Pages.NavBar;
import Pages.ParentFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _01_SearchBar {
    NavBar nb = new NavBar();
    @Given("the user selects a {string} on search dropdown")
    public void theUserSelectsAOnSearchDropdown(String text) {
        nb.selectByVisibleTextNB("dropDownBox",text);
    }

    @When("the user types {string} into the search bar")
    public void theUserTypesIntoTheSearchBar(String searchText) {
        nb.sendKeysNB("twotabsearchtextbox",searchText);
    }

    @And("the user clicks the search button")
    public void theUserClicksTheSearchButton() {
        nb.clickElementNB("searchBarButton");
    }

    @Then("the info bar message contains {string} name")
    public void theInfoBarMessageContainsName(String text) {
        nb.containsTextNB("searchResult", text);
    }
}
