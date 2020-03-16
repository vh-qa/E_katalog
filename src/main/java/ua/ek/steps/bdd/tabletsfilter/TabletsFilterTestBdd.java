package ua.ek.steps.bdd.tabletsfilter;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseBddStep;
import ua.ek.steps.tablets.TabletsStep;
import ua.ek.steps.tablets.manufacturers.AppleTabletsStep;
import ua.ek.utils.*;

public class TabletsFilterTestBdd {

    private WebDriver driver;
    private Helper helper;

    private HomeStep homeStep;
    private TabletsStep tabletsStep;
    private AppleTabletsStep appleTabletsStep;

    public TabletsFilterTestBdd() {
        driver = BaseBddStep.getWebDriver();
        helper = new Helper(driver);

        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, driver);
        tabletsStep = (TabletsStep) stepFactory.createStep(StepType.TABLETS_STEP, driver);
        appleTabletsStep = (AppleTabletsStep) stepFactory.createStep(StepType.APPLE_TABLETS_STEP, driver);
    }

    @Given("^User open the home page$")
    public void userOpenHomePage()  {
        homeStep.goHomePage();
    }

    @When("^User go tablets page$")
    public void userOpenTabletsPage()  {
        tabletsStep.goTabletsPage();
    }

    @And("^User click on (.*?) checkbox$")
    public void userClickOnManufacturerCheckBox(String manufacturer)  {
        tabletsStep.clickManufacturer(manufacturer);
    }

    @And("^User click on show button$")
    public void userClickOnShowButton()  {
        tabletsStep.clickShowButton();
    }

    @Then("^User should see page with text (.*?)$")
    public void userShouldSeePageWithListOfAppleTablets(String text) {
        AssertUtils.makeAssert(appleTabletsStep.getPageTitleText(), text);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}