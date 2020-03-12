package ua.ek.steps.search;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.search.SearchPage;
import ua.ek.pages.search.SearchResultPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.IWaitTimes;
import ua.ek.utils.PageType;

public class SearchStep extends BaseStep {

    private WebDriver driver;
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;

    public SearchStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        searchPage = (SearchPage)getPage(PageType.SEARCH_PAGE, driver);
        searchResultPage = (SearchResultPage)getPage(PageType.SEARCH_RESULT_PAGE, driver);
    }

    public SearchStep goSearchPage () {
        return new SearchStep(driver);
    }

    public SearchStep enterSearchTextInSearchField (String searchText){
        getHelper().enterTextInTextField(searchPage.getSearchField(), searchText);
        return new SearchStep(driver);
    }

    public SearchStep makeSearch() {
        getHelper().clickWebElement(searchPage.getSearchButton());
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, searchPage.getSearchButton()).click();
        return new SearchStep(driver);
    }

    public String getSearchListTitleText(){
        return getHelper().getTextFromWebElement(searchResultPage.getSearchListTitleElement());
    }
}