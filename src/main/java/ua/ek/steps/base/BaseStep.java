package ua.ek.steps.base;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.HomePage;
import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsListPage;
import ua.ek.pages.tablets.TabletsManufacturerPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.pages.tablets.manufacturers.AppleTabletsPage;
import ua.ek.utils.PropertyReader;

public class BaseStep {
    private WebDriver driver;

    private AuthPage authPage;
    private TabletPage tabletPage;
    private TabletsPage tabletsPage;
    private TabletsListPage tabletsListPage;
    private TabletsManufacturerPage tabletsManufacturerPage;
    private AppleTabletsPage appleTabletsPage;

    protected void init(){
        tabletPage = new TabletPage(driver);
        tabletsPage = new TabletsPage(driver);
        tabletsListPage = new TabletsListPage(driver);
        tabletsManufacturerPage = new TabletsManufacturerPage(driver);
        authPage = new AuthPage(driver);
        appleTabletsPage = new AppleTabletsPage(driver);
    }

    public BaseStep(WebDriver driver){
        this.driver = driver;
        init();
    }

    public AuthPage getAuthPage() {
        return authPage;
    }

    public TabletPage getTabletPage() {
        return tabletPage;
    }

    public TabletsPage getTabletsPage() {
        return tabletsPage;
    }

    public TabletsListPage getTabletsListPage() {
        return tabletsListPage;
    }

    public TabletsManufacturerPage getTabletsManufacturerPage(){
        return tabletsManufacturerPage;
    }

    public AppleTabletsPage getAppleTabletsPage() {
        return appleTabletsPage;
    }

    public HomePage goHomePage(WebDriver driver){

        String baseUrl = PropertyReader
                .from("/properties/common.properties", "base.url")
                .getProperty("base.url");

        driver.get(baseUrl);
        return new HomePage(driver);
    }
}