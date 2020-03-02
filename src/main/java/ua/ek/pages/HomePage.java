package ua.ek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.pages.registration.RegistrationPage;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.pages.tablets.manufacturers.AppleTabletsPage;
import ua.ek.utils.IWaitTimes;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//ul[contains(@class,'mainmenu-list')]/li/a[contains(text(),'Компьютеры')]")
    private WebElement computersLink; // Menu "Компьютеры"

    @FindBy(xpath = "(.//div[@class='mainmenu-sublist']/a[@class='mainmenu-subitem mainmenu-icon30'])[1]")
    private WebElement tabletsLink; // SubMenu "Планшеты"

    @FindBy(xpath = ".//*[@id='li_br116']/label") // Apple
    private WebElement manufacturerApple;

    public RegistrationPage clickEnterLink() {
        if (getEnterLink() != null) {
            helper.clickWebElement(getEnterLink());
            return new RegistrationPage(driver);
        }
        return null;
    }

    public TabletsPage clickTabletsLink() {
        helper.clickWebElement(computersLink);
        helper.clickElementWithJS(tabletsLink);

        return new TabletsPage(driver);
    }

    public TabletPage clickTabletLink() {
        helper.clickWebElement(computersLink);
        helper.clickElementWithJS(tabletsLink);

        return new TabletPage(driver);
    }

    public AppleTabletsPage clickAppleTabletsCheckBox(){
        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, computersLink);
        helper.clickElementWithJS(computersLink);
        helper.clickElementWithJS(tabletsLink);

        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, manufacturerApple);
        helper.clickElementWithJS(manufacturerApple);

        return new AppleTabletsPage(driver);
    }
}