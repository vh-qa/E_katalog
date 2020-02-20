package ua.ek.xpath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import ua.ek.base.BasePage;
import ua.ek.base.BaseTest;
import ua.ek.pages.PageManager;
import ua.ek.pages.xpath.AppleTabletsPage;

import static org.testng.Assert.assertEquals;

public class AppleTabletsTest extends BaseTest {
    private final static Logger LOG = LogManager.getLogger(BasePage.class);
    private PageManager pageManager = new PageManager();

    @Test
    public void xpathTest(){
        AppleTabletsPage appleTabletsPage = pageManager.goAppleTabletsPage(driver);
        appleTabletsPage.clickShowButton();

        try {
            assertEquals(appleTabletsPage.getPageTitleText(), "Планшеты Apple ");
            LOG.info("Actual Error message: {} - Expected error message: {}",
                    appleTabletsPage.getPageTitleText(), "Планшеты Apple ");
        } catch (Error e) {
            verificationErrors.append("<<<<<<<<<<<<<<<<<<<<" + "\n" +
                    e.toString() + "\n" + ">>>>>>>>>>>>>>>>>>>>");
        }

        String str = "";
    }
}
