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
//     getHelper().clickStalenessOfWebElementWithJS(getHomePage().getComputersMenuLink());
//     getHelper().clickStalenessOfWebElementWithJS(getHomePage().getTabletsSubMenuLink());
//        getHelper().clickToBeSelectedWebElementWithJS(getHomePage().getComputersMenuLink());
//        getHelper().clickToBeSelectedWebElementWithJS(getHomePage().getTabletsSubMenuLink());
        getHelper().clickVisibleWebElementWithJS(getHomePage().getComputersMenuLink());
        getHelper().clickVisibleWebElementWithJS(getHomePage().getTabletsSubMenuLink());
        return this;
    }

    public TabletsStep clickManufacturerCheckBox(String manufacturerName) {

        switch (manufacturerName.trim().toLowerCase()) {
            case IManufacturers.APPLE:
                clickManufacturerCheckBox(tabletsPage.getManufacturerApple());
                break;
            case IManufacturers.GOOGLE:
                clickManufacturerCheckBox(tabletsPage.getManufacturerGoogle());
                break;
            case IManufacturers.SAMSUNG:
                clickManufacturerCheckBox(tabletsPage.getManufacturerSamsung());
                break;
            default:
                break;
        }

        return this;
    }

    public void clickManufacturerCheckBox(WebElement webElement) {
        getHelper().clickStalenessOfWebElementWithJS(webElement);
    }

    public TabletsStep clickDisplayDiagonalCheckBox(int displayDiagonal) {
        switch (displayDiagonal) {
            case IDisplayDiagonals.TEN_INCH:
                clickDisplayDiagonalCheckBox(tabletsPage.getDisplayDiagonal10inch());
                break;
            default:
                break;
        }

        return this;
    }

    public void clickDisplayDiagonalCheckBox(WebElement webElement) {
        getHelper().elementToBeSelected(webElement, IWaitTimes.FIVE_SECONDS);
        getHelper().clickStalenessOfWebElementWithJS(webElement);
    }

    public TabletsStep clickShowButton() {
        getHelper().clickStalenessOfWebElementWithJS(tabletsPage.getShowButton());
        return this;
    }
}