package ua.ek.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ua.ek.base.BasePage;
import ua.ek.utils.Helper;
import ua.ek.utils.ITimeOfWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@class,'mainmenu-link') and text()='Компьютеры']")
    private WebElement computersLink; // Menu "Компьютеры"

    @FindBy(xpath = "//div[@class='mainmenu-sublist']//a[@class='mainmenu-subitem mainmenu-icon30']")
    private WebElement mapCasesLink; // SubMenu "Планшеты"

    public AuthPage clickEnterLink() {
        if (getEnterLink() != null) {
            Helper.clickWebElement(getEnterLink());
            return new AuthPage(driver);
        }
        return null;
    }

    public MapCasesPage clickMapCasesLink() {

        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, getWebElement(computersLink));
        if (isWebElementDisplayed(getWebElement(computersLink))) {
            Helper.clickWebElement(getWebElement(computersLink));
        }


        Actions builder = new Actions(driver);
//      builder.moveToElement(getWebElement(computersLink));
        builder.moveToElement(getWebElement(mapCasesLink)).click().perform();


/*
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, mapCasesLink);
        if (isWebElementDisplayed(mapCasesLink)) {
            Helper.clickWebElement(mapCasesLink);
        }
*/
        return new MapCasesPage(driver);
    }

    public WebElement getWebElement(WebElement webElement){
        return webElement;
    }
}
