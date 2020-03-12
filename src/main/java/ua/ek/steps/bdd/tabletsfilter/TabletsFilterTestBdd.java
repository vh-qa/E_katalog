package ua.ek.steps.bdd.tabletsfilter;

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

    @Given("^I am on home page$")
    public void i_am_on_home_page()  {
        homeStep.goHomePage();
    }

    @When("^I go tablets page$")
    public void i_click_on_Компьютеры_link()  {
        tabletsStep.goTabletsPage();
    }

    @And("^I click on \"([^\"]*)\" checkbox$")
    public void i_click_on_checkbox(String manufacturer)  {
        tabletsStep.clickManufacturer(manufacturer);
    }

    @And("^I click on 'Показать' button$")
    public void i_click_on_Показать_button()  {
        tabletsStep.clickShowButton();
    }

    @Then("^I am on page with list of Apples tablets$")
    public void i_am_on_page_with_list_of_Apples_tablets() {
        AssertUtils.makeAssert(appleTabletsStep.getPageTitleText(), "Планшеты Apple");
    }
}