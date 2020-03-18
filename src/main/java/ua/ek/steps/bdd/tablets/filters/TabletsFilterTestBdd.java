package ua.ek.steps.bdd.tablets.filters;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ua.ek.steps.HomeStep;
import ua.ek.steps.tablets.TabletsListStep;
import ua.ek.steps.tablets.TabletsStep;
import ua.ek.steps.tablets.filters.PriceFilterStep;
import ua.ek.utils.*;

public class TabletsFilterTestBdd {

    private WebDriver driver;
    private Helper helper;

    private HomeStep homeStep;
    private TabletsStep tabletsStep;
    private PriceFilterStep priceFilterStep;
    private TabletsListStep tabletsListStep;

    public TabletsFilterTestBdd() {
        InitRemoteDrivers initRemoteDrivers = new InitRemoteDrivers();
        initRemoteDrivers.initWithDefaultValues();
        driver = initRemoteDrivers.getDriver();
        helper = new Helper(driver);

        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, driver);
        tabletsStep = (TabletsStep) stepFactory.createStep(StepType.TABLETS_STEP, driver);
        priceFilterStep = (PriceFilterStep)stepFactory.createStep(StepType.PRICE_FILTER_STEP, driver);
        tabletsListStep = (TabletsListStep)stepFactory.createStep(StepType.TABLETS_LIST_STEP, driver);
    }

    @Given("^User open the home page$")
    public void userOpenHomePage()  {
        homeStep.goHomePage();
    }

    @When("^User go tablets page$")
    public void userOpenTabletsPage()  {
        tabletsStep.goTabletsPage();
    }

    @And("^User click on (.*?) checkbox in manufacturer filter panel$")
    public void userClickOnManufacturerCheckBox(String manufacturer)  {
        tabletsStep.clickManufacturerCheckBox(manufacturer);
    }

    @And("^User click on (.*?) inches checkbox in display diagonal filter panel$")
    public void userClickOnDisplayDiagonalCheckBox(String displayDiagonal)  {
        tabletsStep.clickDisplayDiagonalCheckBox(Helper.convertStringToInt(displayDiagonal));
    }

    @And("^User enter (.*?) in min price field$")
    public void userEnterValueInMinPriceField(String minPrice){
        priceFilterStep.enterMinPriceInMinPriceField(minPrice);
    }

    @And("^User enter (.*?) in max price field$")
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

    @Then("^User should see page with text in range price (.*?)$")
    public void userShouldSeePageWithListOfTabletsInRangePrice(String resultPrice) {
        AssertUtils.makeAssert(tabletsListStep.getStickerTextElement(), resultPrice);
    }

    @Then("^User should see page with text (.*?) according to the selected manufacturer and display diagonal filters$")
    public void userShouldSeePageWithListOfTabletsAccordingSelectedFilters(String resultText){
        AssertUtils.makeAssert(tabletsListStep.getTabletsListTitle(), resultText);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}