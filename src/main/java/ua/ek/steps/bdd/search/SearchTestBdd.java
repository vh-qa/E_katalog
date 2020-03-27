package ua.ek.steps.bdd.search;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ua.ek.pages.search.SearchPage;
import ua.ek.pages.search.SearchResultPage;
import ua.ek.steps.base.BaseStepBdd;
import ua.ek.utils.*;

public class SearchTestBdd extends BaseStepBdd {
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;

    public SearchTestBdd() {
        searchPage = (SearchPage) getPage(PageType.SEARCH_PAGE, getDriver());
        searchResultPage = (SearchResultPage)getPage(PageType.SEARCH_RESULT_PAGE, getDriver());
    }

    @Given("^User go to the search panel$")
    public void userGoToSearchPanel() {
        getDriver()
                .get(getHomePage()
                        .getBaseUrl());
    }

    @When("^User enter search text (.*?) in search field$")
    public void userEnterSearchTextInSearchField(String searchText) {
        getHelper().enterTextInTextField(searchPage.getSearchField(), searchText);
    }

    @And("^User click on search button$")
    public void userClickSubmitButton() {
        getHelper().clickWebElement(searchPage.getSearchButton());
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, searchPage.getSearchButton()).click();
    }

    @Then("^User should see page with text (.*?) according to the search text$")
    public void userShouldSeePageWithText(String searchResultText) {
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(searchResultPage.getSearchListTitleElement()), searchResultText);
    }

    @And("^User close browser after tablets search$")
    public void userCloseBrowserAfterTabletsSearch(){
        getDriver().quit();
    }
}