package ua.ek.steps.search;

import org.openqa.selenium.WebDriver;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.IWaitTimes;

public class SearchStep extends BaseStep {

    private WebDriver driver;

    public SearchStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SearchStep goSearchPage () {
        return new SearchStep(driver);
    }

    public SearchStep enterSearchTextInSearchField (String searchText){
        getHelper().enterTextInTextField(getSearchPage().getSearchField(), searchText);
        return new SearchStep(driver);
    }

    public SearchStep makeSearch() {
        getHelper().clickWebElement(getSearchPage().getSearchButton());
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, getSearchPage().getSearchButton()).click();
        return new SearchStep(driver);
    }

    public String getSearchListTitleText(){
        return getHelper().getTextFromWebElement(getSearchResultPage().getSearchListTitleElement());
    }
}