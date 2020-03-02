package ua.ek.steps.base;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.HomePage;
import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.registration.RegistrationPage;
import ua.ek.pages.search.SearchPage;
import ua.ek.pages.search.SearchResultPage;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsListPage;
import ua.ek.pages.tablets.TabletsManufacturerPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.pages.tablets.manufacturers.AppleTabletsPage;
import ua.ek.utils.PropertyReader;

public abstract class BaseStep {
    private WebDriver driver;

    private RegistrationPage registrationPage;
    private AuthPage authPage;
    private TabletPage tabletPage;
    private TabletsPage tabletsPage;
    private TabletsListPage tabletsListPage;
    private TabletsManufacturerPage tabletsManufacturerPage;
    private AppleTabletsPage appleTabletsPage;
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;

    protected void init(){
        registrationPage = new RegistrationPage(driver);
        authPage = new AuthPage(driver);
        tabletPage = new TabletPage(driver);
        tabletsPage = new TabletsPage(driver);
        tabletsListPage = new TabletsListPage(driver);
        tabletsManufacturerPage = new TabletsManufacturerPage(driver);
        appleTabletsPage = new AppleTabletsPage(driver);
        searchPage = new SearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    public BaseStep(WebDriver driver){
        this.driver = driver;
        init();
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
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

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public SearchResultPage getSearchResultPage() {
        return searchResultPage;
    }

    public HomePage goHomePage(WebDriver driver){

        String baseUrl = PropertyReader
                .from("/properties/common.properties", "base.url")
                .getProperty("base.url");

        driver.get(baseUrl);
        return new HomePage(driver);
    }
}