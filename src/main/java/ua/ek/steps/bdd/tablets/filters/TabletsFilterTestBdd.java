package ua.ek.steps.bdd.tablets.filters;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebElement;
import ua.ek.pages.tablets.TabletsListPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.pages.tablets.filters.PriceFilter;
import ua.ek.steps.base.BaseStepBdd;
import ua.ek.utils.*;

public class TabletsFilterTestBdd extends BaseStepBdd {
    private PriceFilter priceFilter;
    private TabletsPage tabletsPage;
    private TabletsListPage tabletsListPage;

    public TabletsFilterTestBdd() {
        priceFilter = (PriceFilter)getPage(PageType.PRICE_FILTER_PAGE, getDriver());
        tabletsPage = (TabletsPage)getPage(PageType.TABLETS_PAGE, getDriver());
        tabletsListPage = (TabletsListPage)getPage(PageType.TABLETS_LIST_PAGE, getDriver());
    }

    @Given("^User go tablets page for testing right panel filters$")
    public void userOpenTabletsPage()  {
        getHelper().clickToBeSelectedWebElementWithJS(getHomePage().getComputersMenuLink());
        getHelper().clickToBeSelectedWebElementWithJS(getHomePage().getTabletsSubMenuLink());
    }

    @When("^User click on (.*?) checkbox in manufacturer filter panel$")
    public void userClickOnManufacturerCheckBox(String manufacturerName)  {
        switch (manufacturerName.trim().toLowerCase()) {
            case IManufacturers.APPLE:
                clickManufacturerCheckBox(tabletsPage.getManufacturerApple());
                break;
            case IManufacturers.GOOGLE:
                clickManufacturerCheckBox(tabletsPage.getManufacturerGoogle());
                break;
            case IManufacturers.SAMSUNG:
                clickManufacturerCheckBox(tabletsPage.getManufacturerSamsung());
                break;
            default:
                break;
        }
    }

    @When("^User click on (.*?) inches checkbox in display diagonal filter panel$")
    public void userClickOnDisplayDiagonalCheckBox(String displayDiagonal)  {
        switch (Helper.convertStringToInt(displayDiagonal)) {
            case IDisplayDiagonals.TEN_INCH:
                clickDisplayDiagonalCheckBox(tabletsPage.getDisplayDiagonal10inch());
                break;
            default:
                break;
        }
    }

    @When("^User enter (.*?) in min price field in right panel filter$")
    public void userEnterValueInMinPriceField(String minPrice){
        getHelper().enterTextInTextField(priceFilter.getMinPriceInput(), minPrice);
    }

    @And("^User enter (.*?) in max price field in right panel filter$")
    public void userEnterValueInMaxPriceField(String maxPrice){
        getHelper().enterTextInTextField(priceFilter.getMaxPriceInput(), maxPrice);
    }

    @And("^User click on show button$")
    public void userClickOnShowButton()  {
        getHelper().clickStalenessOfWebElementWithJS(tabletsPage.getShowButton());
    }

    @Then("^User should see page with text (.*?) according to the selected manufacturer filter$")
    public void userShouldSeePageWithListOfTabletsAccordingSelectedManufacturerFilter(String resultText){
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(tabletsListPage.getTabletsListTitle()), resultText);
    }

    @Then("^User should see page with text (.*?) according to the selected display diagonal filter$")
    public void userShouldSeePageWithListOfAppleTablets(String resultText) {
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(tabletsListPage.getTabletsListTitle()), resultText);
    }

    @Then("^User should see page with text in range price (.*?) according to the entered prices$")
    public void userShouldSeePageWithListOfTabletsInRangePrice(String resultPrice) {
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(tabletsListPage.getStickerTextElement()), resultPrice);
    }

    @Then("^User should see page with text (.*?) according to the selected manufacturer and display diagonal filters$")
    public void userShouldSeePageWithListOfTabletsAccordingSelectedFilters(String resultText){
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(tabletsListPage.getTabletsListTitle()), resultText);
    }

    @And("^User close browser after using right panel filter$")
    public void userCloseBrowserAfterUsingFilter(){
        getDriver().quit();
    }

    public void clickManufacturerCheckBox(WebElement webElement) {
        getHelper().clickStalenessOfWebElementWithJS(webElement);
    }

    public void clickDisplayDiagonalCheckBox(WebElement webElement) {
        getHelper().elementToBeSelected(webElement, IWaitTimes.TEN_SECONDS);
        getHelper().clickStalenessOfWebElementWithJS(webElement);
    }
}