package ua.ek.search;

import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.utils.AssertUtils;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest(){
        getSearchStep().goSearchPage()
                       .enterSearchTextInSearchField("планшеты apple")
                       .makeSearch();

        AssertUtils.makeAssert(getSearchStep().getSearchListTitleText(), "Планшеты Apple");
    }
}
