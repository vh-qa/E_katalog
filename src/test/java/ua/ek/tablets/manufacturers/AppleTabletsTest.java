package ua.ek.tablets.manufacturers;

import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.pages.PageManager;
import ua.ek.pages.tablets.manufacturers.AppleTabletsPage;
import ua.ek.utils.AssertUtils;

public class AppleTabletsTest extends BaseTest {

    private PageManager pageManager = new PageManager();

    @Test
    public void xpathTest(){
        AppleTabletsPage appleTabletsPage = pageManager.goAppleTabletsPage(driver);
        appleTabletsPage.clickShowButton();

        AssertUtils.makeAssert(appleTabletsPage.getPageTitleText(), "Планшеты Apple ");
    }
}