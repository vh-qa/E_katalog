package ua.ek.tablets.manufacturers;

import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.utils.AssertUtils;

public class AppleTabletsTest extends BaseTest {

    @Test
    public void xpathTest(){
        appleTabletsStep.goAppleTabletsPage(driver);
        appleTabletsStep.clickShowButton();

        AssertUtils.makeAssert(appleTabletsStep.getPageTitleText(), "Планшеты Apple ");
    }
}