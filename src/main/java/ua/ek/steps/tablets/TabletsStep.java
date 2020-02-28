package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.ek.pages.tablets.TabletsManufacturerPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.Helper;
import ua.ek.utils.IManufacturers;
import ua.ek.utils.IWaitTimes;
import ua.ek.utils.IDisplayDiagonals;

public class TabletsStep extends BaseStep {

    private WebDriver driver;
    private Helper helper;

    public TabletsStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new Helper(driver);
    }

    public TabletsPage goTabletsPage(WebDriver driver){
        return goHomePage(driver).clickTabletsLink();
    }

    public TabletsPage clickManufacturer(String manufacturerName) {

        switch (manufacturerName.trim().toLowerCase()) {
            case IManufacturers.APPLE:
                clickManufacturer(getTabletsPage().getManufacturerApple());
                break;
            case IManufacturers.GOOGLE:
                clickManufacturer(getTabletsPage().getManufacturerGoogle());
                break;
            case IManufacturers.SAMSUNG:
                clickManufacturer(getTabletsPage().getManufacturerSamsung());
                break;
            default:
                break;
        }

        return new TabletsPage(driver);
    }

    public void clickManufacturer(WebElement webElement) {
//      helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, webElement);
        helper.elementToBeSelected(webElement, IWaitTimes.FIVE_SECONDS);
        helper.clickElementWithJS(webElement);
    }

    public TabletsPage clickDisplayDiagonal(int displayDiagonal) {
        switch (displayDiagonal) {
            case IDisplayDiagonals.TEN_INCH:
                clickDisplayDiagonal(getTabletsPage().getDisplayDiagonal10inch());
                break;
            default:
                break;
        }

        return new TabletsPage(driver);
    }

    public void clickDisplayDiagonal(WebElement webElement) {
 //     helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, webElement);
        helper.elementToBeSelected(webElement, IWaitTimes.FIVE_SECONDS);
        helper.clickElementWithJS(webElement);
    }

    public TabletsManufacturerPage clickShowButton() {
        helper.clickElementWithJS(getTabletsPage().getShowButton());
        return new TabletsManufacturerPage(driver);
    }
}
