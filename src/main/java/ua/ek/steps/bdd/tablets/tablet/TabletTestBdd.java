package ua.ek.steps.bdd.tablets.tablet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsListPage;
import ua.ek.steps.base.BaseStepBdd;
import ua.ek.utils.*;

public class TabletTestBdd extends BaseStepBdd {

private TabletPage tabletPage;
    private TabletsListPage tabletsListPage;

    public TabletTestBdd(){
        tabletPage = (TabletPage)getPage(PageType.TABLET_PAGE, getDriver());
        tabletsListPage = (TabletsListPage)getPage(PageType.TABLETS_LIST_PAGE, getDriver());
    }

    @Given("^User go tablets page$")
    public void userOpenTabletsPage()  {
        getHelper().clickVisibleWebElementWithJS(getHomePage().getComputersMenuLink());
        getHelper().clickVisibleWebElementWithJS(getHomePage().getTabletsSubMenuLink());
    }

    @When("^User click on apple manufacturer link in the filter panel$")
    public void userClickManufacturerLinkInFilterPanel(){
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                tabletPage.getManufacturerLink()).click();
    }

    @When("^User click on 10 inches display diagonal link in the filter panel$")
    public void userClickDisplayDiagonalLinkInFilterPanel(){
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                tabletPage.getDisplayDiagonalLink()).click();
    }

    @When("^User click on 7000 — 10000 грн. link in the filter panel$")
    public void userClickFixedPriceLinkInFilterPanel(){
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                tabletPage.getFixedPriceLink()).click();
    }

    @When("^User enter (.*?) in min price field$")
    public void userEnterMinPrice(String minPrice){
        getHelper().enterTextInTextField(tabletPage.getMinPriceField(), minPrice);
    }

    @And("^User enter (.*?) in max price field$")
    public void userEnterMaxPrice(String maxPrice){
        getHelper().enterTextInTextField(tabletPage.getMaxPriceField(), maxPrice);
    }

    @And("^User click on submit button$")
    public void userClickOnSubmitButton(){
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                tabletPage.getSubmitButton()).click();
    }

    @Then("^User should see page with text (.*?) according to the selected manufacturer link$")
    public void userShouldSeePageWithTextAccordingSelectedManufacturerLink(String actualMessage){
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(tabletsListPage.getTabletsListTitle()), actualMessage);
    }

    @Then("^User should see page with text (.*?) according to the selected display diagonal link$")
    public void userShouldSeePageWithTextAccordingSelectedDisplayDiagonalLink(String actualMessage){
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(tabletsListPage.getTabletsListTitle()), actualMessage);
    }

    @Then("^User should see page with text (.*?) according to the selected fixed price link$")
    public void userShouldSeePageWithTextAccordingSelectedFixedPriceLink(String actualMessage){
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(tabletsListPage.getStickerTextElement()), actualMessage);
    }

    @Then("^User should see page with text in range price (.*?)$")
    public void userShouldSeePageWithTextInRangePrice(String actualMessage){
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(tabletsListPage.getStickerTextElement()), actualMessage);
    }

    @And("^User close browser after using top panel filter$")
    public void userCloseBrowserAfterUsingTopPanelFilter(){
        getDriver().quit();
    }
}