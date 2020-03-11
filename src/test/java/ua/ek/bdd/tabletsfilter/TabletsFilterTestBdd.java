package ua.ek.bdd.tabletsfilter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ua.ek.base.BaseTest;
import ua.ek.steps.HomeStep;
import ua.ek.steps.tablets.TabletsStep;
import ua.ek.steps.tablets.manufacturers.AppleTabletsStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.Helper;
import ua.ek.utils.InitDrivers;

public class TabletsFilterTestBdd extends BaseTest {

    WebDriver driver;
    Helper helper;
    HomeStep homeStep;
    TabletsStep tabletsStep;
    AppleTabletsStep appleTabletsStep;

    public TabletsFilterTestBdd() {

        InitDrivers initDrivers = new InitDrivers();
        try {
            initDrivers.setUp("chrome");
        }catch(Exception e){
            e.printStackTrace();
        }

        driver = initDrivers.getWebDriver();

        helper = new Helper(driver);
        homeStep = new HomeStep(driver);
        tabletsStep = new TabletsStep(driver);
        appleTabletsStep = new AppleTabletsStep(driver);
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