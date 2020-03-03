package ua.ek.steps.search;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.HomePage;
import ua.ek.pages.search.SearchPage;
import ua.ek.pages.search.SearchResultPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.Helper;
import ua.ek.utils.IWaitTimes;

public class SearchStep extends BaseStep {

    private WebDriver driver;
    private Helper helper;

    public SearchStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new Helper(driver);
    }

    public HomePage goSearchPage (WebDriver driver) {
        return new HomePage(driver);
    }

    public SearchPage enterSearchTextInSearchField (String searchText){
        helper.enterTextInTextField(getSearchPage().getSearchField(), searchText);
        return new SearchPage(driver);
    }

    public SearchResultPage makeSearch() {
        helper.clickWebElement(getSearchPage().getSearchButton());
        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, getSearchPage().getSearchButton()).click();
        return new SearchResultPage(driver);
    }

    public String getSearchListTitleText(){
        return helper.getWebElementText(getSearchResultPage().getSearchListTitleElement());
    }
}
