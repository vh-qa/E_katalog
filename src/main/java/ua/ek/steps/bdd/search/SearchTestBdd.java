package ua.ek.steps.bdd.search;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseStepBdd;
import ua.ek.steps.search.SearchStep;
import ua.ek.utils.*;

public class SearchTestBdd extends BaseStepBdd {
    private HomeStep homeStep;
    private SearchStep searchStep;

    public SearchTestBdd() {
        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, getDriver());
        searchStep = (SearchStep) stepFactory.createStep(StepType.SEARCH_STEP, getDriver());
    }

    @Given("^User go to the search panel$")
    public void userGoToSearchPanel() {
        homeStep.goHomePage();
    }

    @When("^User enter search text (.*?) in search field$")
    public void userEnterSearchTextInSearchField(String searchText) {
        searchStep.enterSearchTextInSearchField(searchText);
    }

    @And("^User click on search button$")
    public void userClickSubmitButton() {
        searchStep.makeSearch();
    }

    @Then("^User should see page with text (.*?) according to the search text$")
    public void userShouldSeePageWithText(String searchResultText) {
        AssertUtils.makeAssert(searchStep.getSearchListTitleText(), searchResultText);
    }

    @And("^User close browser after tablets search$")
    public void userCloseBrowserAfterTabletsSearch(){
        getDriver().quit();
    }
}