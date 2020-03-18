package ua.ek.steps.bdd.tablets.tablet;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;

import ua.ek.steps.HomeStep;
import ua.ek.steps.tablets.TabletStep;
import ua.ek.steps.tablets.TabletsListStep;
import ua.ek.utils.*;

public class TabletTestBdd {

    private WebDriver driver;
    private Helper helper;

    private HomeStep homeStep;
    private TabletStep tabletStep;
    private TabletsListStep tabletsListStep;

    public TabletTestBdd(){
        InitRemoteDrivers initRemoteDrivers = new InitRemoteDrivers();
        initRemoteDrivers.initWithDefaultValues();
        driver = initRemoteDrivers.getDriver();
        helper = new Helper(driver);

        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, driver);
        tabletStep = (TabletStep)stepFactory.createStep(StepType.TABLET_STEP, driver);
        tabletsListStep = (TabletsListStep) stepFactory.createStep((StepType.TABLETS_LIST_STEP), driver);
    }

    @Given("^User open the home page$")
    public void userOpenHomePage()  {
        homeStep.goHomePage();
    }

    @When("^User go tablets page$")
    public void userOpenTabletsPage()  {
        tabletStep.goTabletPage();
    }

    @And("^User click on apple manufacturer link in the filter panel$")
    public void userClickManufacturerLinkInFilterPanel(){
        tabletStep.clickManufacturerLink();
    }

    @And("^User click on 10 inches display diagonal link in the filter panel$")
    public void userClickDisplayDiagonalLinkInFilterPanel(){
        tabletStep.clickDisplayDiagonalLink();
    }

    @And("^User click on 7000 — 10000 грн. link in the filter panel$")
    public void userClickFixedPriceLinkInFilterPanel(){
        tabletStep.clickFixedPriceLink();
    }

    @And("^User enter (.*?) in min price field$")
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
}