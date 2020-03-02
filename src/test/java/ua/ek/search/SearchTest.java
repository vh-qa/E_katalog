package ua.ek.search;

import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.pages.search.SearchResultPage;
import ua.ek.utils.AssertUtils;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest(){
        searchStep.goSearchPage(driver);
        searchStep.enterSearchTextInSearchField("планшеты apple");
        searchStep.makeSearch();

        AssertUtils.makeAssert(searchStep.getSearchListTitleText(), "Планшеты Apple");
    }
}
