package ua.ek.page;

import org.openqa.selenium.WebDriver;
import ua.ek.base.BasePage;

public class HomePage extends BasePage {
public HomePage(WebDriver driver){
    super(driver);
}
    public AuthPage clickEnterLink() {
        getLoginLink().click();
        return new AuthPage(driver);
    }
}
