package ua.ek.steps.bdd.tablets.filters;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseStepBdd;
import ua.ek.steps.tablets.TabletsListStep;
import ua.ek.steps.tablets.TabletsStep;
import ua.ek.steps.tablets.filters.PriceFilterStep;
import ua.ek.utils.*;

public class TabletsFilterTestBdd extends BaseStepBdd {
    private HomeStep homeStep;
    private TabletsStep tabletsStep;
    private PriceFilterStep priceFilterStep;
    private TabletsListStep tabletsListStep;

    public TabletsFilterTestBdd() {
        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, getDriver());
        tabletsStep = (TabletsStep) stepFactory.createStep(StepType.TABLETS_STEP, getDriver());
        priceFilterStep = (PriceFilterStep)stepFactory.createStep(StepType.PRICE_FILTER_STEP, getDriver());
        tabletsListStep = (TabletsListStep)stepFactory.createStep(StepType.TABLETS_LIST_STEP, getDriver());
    }

    @Given("^User go tablets page for testing right panel filters$")
    public void userOpenTabletsPage()  {
        tabletsStep.goTabletsPage();
    }

    @When("^User click on (.*?) checkbox in manufacturer filter panel$")
    public void userClickOnManufacturerCheckBox(String manufacturer)  {
        tabletsStep.clickManufacturerCheckBox(manufacturer);
    }

    @When("^User click on (.*?) inches checkbox in display diagonal filter panel$")
    public void userClickOnDisplayDiagonalCheckBox(String displayDiagonal)  {
        tabletsStep.clickDisplayDiagonalCheckBox(Helper.convertStringToInt(displayDiagonal));
    }

    @When("^User enter (.*?) in min price field in right panel filter$")
    public void userEnterValueInMinPriceField(String minPrice){
        priceFilterStep.enterMinPriceInMinPriceField(minPrice);
    }

    @And("^User enter (.*?) in max price field in right panel filter$")
    public void userEnterValueInMaxPriceField(String maxPrice){
        priceFilterStep.enterMaxPriceInMaxPriceField(maxPrice);
    }

    @And("^User click on show button$")
    public void userClickOnShowButton()  {
        tabletsStep.clickShowButton();
    }

    @Then("^User should see page with text (.*?) according to the selected manufacturer filter$")
    public void userShouldSeePageWithListOfTabletsAccordingSelectedManufacturerFilter(String resultText){
        AssertUtils.makeAssert(tabletsListStep.getTabletsListTitle(), resultText);
    }

    @Then("^User should see page with text (.*?) according to the selected display diagonal filter$")
    public void userShouldSeePageWithListOfAppleTablets(String resultText) {
        AssertUtils.makeAssert(tabletsListStep.getTabletsListTitle(), resultText);
    }

    @Then("^User should see page with text in range price (.*?) according to the entered prices$")
    public void userShouldSeePageWithListOfTabletsInRangePrice(String resultPrice) {
        AssertUtils.makeAssert(tabletsListStep.getStickerTextElement(), resultPrice);
    }

    @Then("^User should see page with text (.*?) according to the selected manufacturer and display diagonal filters$")
    public void userShouldSeePageWithListOfTabletsAccordingSelectedFilters(String resultText){
        AssertUtils.makeAssert(tabletsListStep.getTabletsListTitle(), resultText);
    }

    @And("^User close browser after using right panel filter$")
    public void userCloseBrowserAfterUsingFilter(){
        getDriver().quit();
    }
}