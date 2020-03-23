package ua.ek.steps.bdd.tablets.tablet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseStepBdd;
import ua.ek.steps.tablets.TabletStep;
import ua.ek.steps.tablets.TabletsListStep;
import ua.ek.utils.*;

public class TabletTestBdd extends BaseStepBdd {
    private HomeStep homeStep;
    private TabletStep tabletStep;
    private TabletsListStep tabletsListStep;

    public TabletTestBdd(){
        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, getDriver());
        tabletStep = (TabletStep)stepFactory.createStep(StepType.TABLET_STEP, getDriver());
        tabletsListStep = (TabletsListStep) stepFactory.createStep((StepType.TABLETS_LIST_STEP), getDriver());
    }

    @Given("^User go tablets page$")
    public void userOpenTabletsPage()  {
        tabletStep.goTabletPage();
    }

    @When("^User click on apple manufacturer link in the filter panel$")
    public void userClickManufacturerLinkInFilterPanel(){
        tabletStep.clickManufacturerLink();
    }

    @When("^User click on 10 inches display diagonal link in the filter panel$")
    public void userClickDisplayDiagonalLinkInFilterPanel(){
        tabletStep.clickDisplayDiagonalLink();
    }

    @When("^User click on 7000 — 10000 грн. link in the filter panel$")
    public void userClickFixedPriceLinkInFilterPanel(){
        tabletStep.clickFixedPriceLink();
    }

    @When("^User enter (.*?) in min price field$")
    public void userEnterMinPrice(String minPrice){
        tabletStep.enterMinPrice(minPrice);
    }

    @And("^User enter (.*?) in max price field$")
    public void userEnterMaxPrice(String maxPrice){
        tabletStep.enterMaxPrice(maxPrice);
    }

    @And("^User click on submit button$")
    public void userClickOnSubmitButton(){
        tabletStep.clickSubmitButton();
    }

    @Then("^User should see page with text (.*?) according to the selected manufacturer link$")
    public void userShouldSeePageWithTextAccordingSelectedManufacturerLink(String actualMessage){
        AssertUtils.makeAssert(tabletsListStep.getTabletsListTitle(), actualMessage);
    }

    @Then("^User should see page with text (.*?) according to the selected display diagonal link$")
    public void userShouldSeePageWithTextAccordingSelectedDisplayDiagonalLink(String actualMessage){
        AssertUtils.makeAssert(tabletsListStep.getTabletsListTitle(), actualMessage);
    }

    @Then("^User should see page with text (.*?) according to the selected fixed price link$")
    public void userShouldSeePageWithTextAccordingSelectedFixedPriceLink(String actualMessage){
        AssertUtils.makeAssert(tabletsListStep.getStickerTextElement(), actualMessage);
    }

    @Then("^User should see page with text in range price (.*?)$")
    public void userShouldSeePageWithTextInRangePrice(String actualMessage){
        AssertUtils.makeAssert(tabletsListStep.getStickerTextElement(), actualMessage);
    }

    @And("^User close browser after using top panel filter$")
    public void userCloseBrowserAfterUsingTopPanelFilter(){
        getDriver().quit();
    }
}