package ua.ek.steps.tablets;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseStep;
import ua.ek.steps.tablets.manufacturers.AppleTabletsStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.IManufacturers;
import ua.ek.utils.IWaitTimes;
import ua.ek.utils.IDisplayDiagonals;

public class TabletsStep extends BaseStep {

    private HomeStep homeStep;
    private TabletsStep tabletsStep;
    private AppleTabletsStep appleTabletsStep;

    public TabletsStep(WebDriver driver) {
        super(driver);
    }

    public TabletsStep goTabletsPage(){
        getHelper().clickWebElement(getHomePage().getComputersLink());
        getHelper().clickElementWithJS(getHomePage().getTabletsLink());
        return this;
    }

    public TabletsStep clickManufacturer(String manufacturerName) {

        switch (manufacturerName.trim().toLowerCase()) {
            case IManufacturers.APPLE:
                clickManufacturer(getTabletsPage().getManufacturerApple());
                break;
            case IManufacturers.GOOGLE:
                clickManufacturer(getTabletsPage().getManufacturerGoogle());
                break;
            case IManufacturers.SAMSUNG:
                clickManufacturer(getTabletsPage().getManufacturerSamsung());
                break;
            default:
                break;
        }

        return this;
    }

    public void clickManufacturer(WebElement webElement) {
//      getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, webElement);
        getHelper().elementToBeSelected(webElement, IWaitTimes.FIVE_SECONDS);
        getHelper().clickElementWithJS(webElement);
    }

    public TabletsStep clickDisplayDiagonal(int displayDiagonal) {
        switch (displayDiagonal) {
            case IDisplayDiagonals.TEN_INCH:
                clickDisplayDiagonal(getTabletsPage().getDisplayDiagonal10inch());
                break;
            default:
                break;
        }

        return this;
    }

    public void clickDisplayDiagonal(WebElement webElement) {
 //     getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, webElement);
        getHelper().elementToBeSelected(webElement, IWaitTimes.FIVE_SECONDS);
        getHelper().clickElementWithJS(webElement);
    }

    public TabletsStep clickShowButton() {
        getHelper().clickElementWithJS(getTabletsPage().getShowButton());
        return this;
    }

    // Methods for BDD

    @Given("^I am on home page$")
    public void goHomePage()  {
        homeStep.goHomePage();
    }

    @When("^I go tablets page$")
    public void goTabletsPageBDD()  {
        tabletsStep.goTabletsPage();
    }

    @And("^I click on \"([^\"]*)\" checkbox$")
    public void clickCheckBox(String manufacturer)  {
        tabletsStep.clickManufacturer(manufacturer);
    }

    @And("^I click on 'Показать' button$")
    public void clickShowButtonBDD()  {
        tabletsStep.clickShowButton();
    }

    @Then("^I am on page with list of Apples tablets$")
    public void pageWithListOfApplesTablets() {
        AssertUtils.makeAssert(appleTabletsStep.getPageTitleText(), "Планшеты Apple");
    }
}