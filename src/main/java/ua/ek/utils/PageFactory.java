package ua.ek.utils;

import org.openqa.selenium.WebDriver;
import ua.ek.base.BasePage;
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

public class PageFactory {

    public BasePage createPage(PageType pageType, WebDriver driver) {

        BasePage basePage = null;

        switch (pageType) {
            case HOME_PAGE:
                basePage = new HomePage(driver);
                break;
            case AUTH_PAGE:
                basePage = new AuthPage(driver);
                break;
            case REGISTRATION_PAGE:
                basePage = new RegistrationPage(driver);
                break;
            case USER_PROFILE_PAGE:
                basePage = new UserProfilePage(driver);
                break;
            case TABLET_PAGE:
                basePage = new TabletPage(driver);
                break;
            case TABLETS_PAGE:
                basePage = new TabletsPage(driver);
                break;
            case TABLETS_LIST_PAGE:
                basePage = new TabletsListPage(driver);
                break;
            case TABLETS_MANUFACTURER_PAGE:
                basePage = new TabletsManufacturerPage(driver);
                break;
            case APPLE_TABLETS_PAGE:
                basePage = new AppleTabletsPage(driver);
                break;
            case SEARCH_PAGE:
                basePage = new SearchPage(driver);
                break;
            case SEARCH_RESULT_PAGE:
                basePage = new SearchResultPage(driver);
                break;
            case PRICE_FILTER_PAGE:
                basePage = new PriceFilter(driver);
                break;
            default:
                break;
        }

        return basePage;
    }
}