package ua.ek.steps.bdd.search;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ua.ek.steps.HomeStep;
import ua.ek.steps.search.SearchStep;
import ua.ek.utils.*;

public class SearchTestBdd {
    private WebDriver driver;
    private Helper helper;

    private HomeStep homeStep;
    private SearchStep searchStep;

    public SearchTestBdd() {
        InitRemoteDrivers initRemoteDrivers = new InitRemoteDrivers();
        initRemoteDrivers.initWithDefaultValues();
        driver = initRemoteDrivers.getDriver();
        helper = new Helper(driver);

        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, driver);
        searchStep = (SearchStep) stepFactory.createStep(StepType.SEARCH_STEP, driver);
    }

    @Given("^User open the home page$")
    public void userOpenHomePage() {
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

    @Then("^User should see page with text (.*?)$")
    public void userShouldSeePageWithText(String searchResultText) {
        AssertUtils.makeAssert(searchStep.getSearchListTitleText(), searchResultText);
    }
}