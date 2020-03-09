package ua.ek.tablets.manufacturers;

import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.utils.AssertUtils;

public class AppleTabletsTest extends BaseTest {

    @Test
    public void xpathTest(){
        getAppleTabletsStep().goAppleTabletsPage()
                        .clickShowButton();

        AssertUtils.makeAssert(getAppleTabletsStep().getPageTitleText(), "Планшеты Apple ");
    }
}