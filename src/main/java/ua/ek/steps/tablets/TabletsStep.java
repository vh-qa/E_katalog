package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.IManufacturers;
import ua.ek.utils.IWaitTimes;
import ua.ek.utils.IDisplayDiagonals;
import ua.ek.utils.PageType;

public class TabletsStep extends BaseStep {

    private TabletsPage tabletsPage;

    public TabletsStep(WebDriver driver) {
        super(driver);
        tabletsPage = (TabletsPage)getPage(PageType.TABLETS_PAGE, driver);
    }

    public TabletsStep goTabletsPage(){
        getHelper().clickWebElement(getHomePage().getComputersMenuLink());
        getHelper().clickElementWithJS(getHomePage().getTabletsSubMenuLink());
        return this;
    }

    public TabletsStep clickManufacturer(String manufacturerName) {

        switch (manufacturerName.trim().toLowerCase()) {
            case IManufacturers.APPLE:
                clickManufacturer(tabletsPage.getManufacturerApple());
                break;
            case IManufacturers.GOOGLE:
                clickManufacturer(tabletsPage.getManufacturerGoogle());
                break;
            case IManufacturers.SAMSUNG:
                clickManufacturer(tabletsPage.getManufacturerSamsung());
                break;
            default:
                break;
        }

        return this;
    }

    public void clickManufacturer(WebElement webElement) {
        getHelper().clickElementWithJS(webElement);
    }

    public TabletsStep clickDisplayDiagonal(int displayDiagonal) {
        switch (displayDiagonal) {
            case IDisplayDiagonals.TEN_INCH:
                clickDisplayDiagonal(tabletsPage.getDisplayDiagonal10inch());
                break;
            default:
                break;
        }

        return this;
    }

    public void clickDisplayDiagonal(WebElement webElement) {
        getHelper().elementToBeSelected(webElement, IWaitTimes.FIVE_SECONDS);
        getHelper().clickElementWithJS(webElement);
    }

    public TabletsStep clickShowButton() {
        getHelper().clickElementWithJS(tabletsPage.getShowButton());
        return this;
    }
}