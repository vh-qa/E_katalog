package ua.ek.steps.registration;

import org.openqa.selenium.WebDriver;
import ua.ek.steps.base.BaseStep;

public class UserProfileStep extends BaseStep {

    public UserProfileStep(WebDriver driver) {
        super(driver);
    }

    public UserProfileStep clickLogOutFromUserProfileLink() {
        getHelper().clickWebElement(getUserProfilePage().getLogOutFromUserProfileLink());
        return this;
    }

    public String getNickLinkText(){
        return getHelper().getTextFromWebElement(getUserProfilePage().getNickLink());
    }
}