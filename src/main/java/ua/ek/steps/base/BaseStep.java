package ua.ek.steps.base;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.HomePage;
import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.registration.RegistrationPage;
import ua.ek.pages.registration.UserProfilePage;
import ua.ek.pages.search.SearchPage;
import ua.ek.pages.search.SearchResultPage;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsListPage;
import ua.ek.pages.tablets.TabletsManufacturerPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.pages.tablets.filters.PriceFilter;
import ua.ek.pages.tablets.manufacturers.AppleTabletsPage;
import ua.ek.utils.Helper;

public abstract class BaseStep {

    private Helper helper;

    private HomePage homePage;
    private RegistrationPage registrationPage;
    private AuthPage authPage;
    private UserProfilePage userProfilePage;
    private TabletPage tabletPage;
    private TabletsPage tabletsPage;
    private TabletsListPage tabletsListPage;
    private TabletsManufacturerPage tabletsManufacturerPage;
    private AppleTabletsPage appleTabletsPage;
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;
    private PriceFilter priceFilter;

    public BaseStep(WebDriver driver){

        helper = new Helper(driver);

        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        authPage = new AuthPage(driver);
        userProfilePage = new UserProfilePage(driver);
        tabletPage = new TabletPage(driver);
        tabletsPage = new TabletsPage(driver);
        tabletsListPage = new TabletsListPage(driver);
        tabletsManufacturerPage = new TabletsManufacturerPage(driver);
        appleTabletsPage = new AppleTabletsPage(driver);
        searchPage = new SearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
        priceFilter = new PriceFilter(driver);
    }

    public Helper getHelper() {
        return helper;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public AuthPage getAuthPage() {
        return authPage;
    }

    public UserProfilePage getUserProfilePage() {
        return userProfilePage;
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
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