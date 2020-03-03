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
import ua.ek.pages.tablets.filters.PriceFilter;
import ua.ek.pages.tablets.manufacturers.AppleTabletsPage;

public abstract class BaseStep {

    private WebDriver driver;

    private HomePage homePage;
    private RegistrationPage registrationPage;
    private AuthPage authPage;
    private TabletPage tabletPage;
    private TabletsPage tabletsPage;
    private TabletsListPage tabletsListPage;
    private TabletsManufacturerPage tabletsManufacturerPage;
    private AppleTabletsPage appleTabletsPage;
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;
    private PriceFilter priceFilter;

    protected void init(){
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        authPage = new AuthPage(driver);
        tabletPage = new TabletPage(driver);
        tabletsPage = new TabletsPage(driver);
        tabletsListPage = new TabletsListPage(driver);
        tabletsManufacturerPage = new TabletsManufacturerPage(driver);
        appleTabletsPage = new AppleTabletsPage(driver);
        searchPage = new SearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
        priceFilter = new PriceFilter(driver);
    }

    public BaseStep(WebDriver driver){
        this.driver = driver;
        init();
    }

    public HomePage getHomePage() {
        return homePage;
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

    public PriceFilter getPriceFilter() {
        return priceFilter;
    }
}