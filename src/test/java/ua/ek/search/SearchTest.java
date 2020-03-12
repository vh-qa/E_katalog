package ua.ek.search;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.steps.search.SearchStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.PropertyReader;
import ua.ek.utils.StepType;

public class SearchTest extends BaseTest {

    private SearchStep searchStep;

    @BeforeMethod
    public void init(){
        searchStep = (SearchStep) getStep(StepType.SEARCH_STEP);
    }

    @Test
    public void searchTest(){

        String searchText = PropertyReader
                .from("/properties/common.properties",
                        "search.text")
                .getProperty("search.text");

        String searchResultText = PropertyReader
                .from("/properties/expectedMessages.properties",
                        "search.result.text")
                .getProperty("search.result.text");

        searchStep.goSearchPage()
                       .enterSearchTextInSearchField(searchText)
                       .makeSearch();

        AssertUtils.makeAssert(searchStep.getSearchListTitleText(), searchResultText);
    }
}