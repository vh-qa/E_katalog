package ua.ek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.pages.tablets.manufacturers.AppleTabletsPage;

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

    public AuthPage clickEnterLink() {
        if (getEnterLink() != null) {
            clickWebElement(getEnterLink());
            return new AuthPage(driver);
        }
        return null;
    }

    public TabletsPage clickTabletsLink() {
        clickWebElement(computersLink);
        clickElementWithJS(tabletsLink);

        return new TabletsPage(driver);
    }

    public TabletPage clickTabletLink() {
        clickWebElement(computersLink);
        clickElementWithJS(tabletsLink);

        return new TabletPage(driver);
    }

    public AppleTabletsPage clickAppleTabletsCheckBox(){
        waitUntilElementIsVisible(FIVE_SECONDS, computersLink);
        clickElementWithJS(computersLink);
        clickElementWithJS(tabletsLink);

        waitUntilElementIsVisible(FIVE_SECONDS, manufacturerApple);
        clickElementWithJS(manufacturerApple);

        return new AppleTabletsPage(driver);
    }

    public WebElement getWebElement(WebElement webElement){
        return webElement;
    }
}