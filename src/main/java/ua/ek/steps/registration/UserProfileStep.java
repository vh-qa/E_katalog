package ua.ek.steps.registration;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.registration.UserProfilePage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.PageType;

public class UserProfileStep extends BaseStep {

    private UserProfilePage userProfilePage;

    public UserProfileStep(WebDriver driver) {
        super(driver);
        userProfilePage = (UserProfilePage)getPage(PageType.USER_PROFILE_PAGE, driver);
    }

    public void clickLogOutFromUserProfileLink() {
        getHelper().clickWebElement(userProfilePage.getLogOutFromUserProfileLink());
    }

    public String getNickLinkText(){
        return getHelper().getTextFromStalenessOfWebElement(userProfilePage.getNickLink());
//      return getHelper().getTextFromWebElement(userProfilePage.getNickLink());
    }
}