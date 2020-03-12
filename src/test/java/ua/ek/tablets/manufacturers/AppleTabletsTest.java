package ua.ek.tablets.manufacturers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.steps.tablets.manufacturers.AppleTabletsStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.PropertyReader;
import ua.ek.utils.StepType;

public class AppleTabletsTest extends BaseTest {

   private AppleTabletsStep appleTabletsStep;

    @BeforeMethod
    public void init(){
        appleTabletsStep = (AppleTabletsStep)getStep(StepType.APPLE_TABLETS_STEP);
    }

    @Test
    public void xpathTest(){

        String pageTitleText = PropertyReader
                .from("/properties/common.properties",
                        "apple.tablets")
                .getProperty("apple.tablets");

        appleTabletsStep.goAppleTabletsPage()
                        .clickShowButton();

        AssertUtils.makeAssert(appleTabletsStep.getPageTitleText(), pageTitleText);
    }
}