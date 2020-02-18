package ua.ek.pages;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.utils.PropertyReader;

public class PageManager {

    public HomePage goHomePage(WebDriver driver){

        String baseUrl = PropertyReader
                .from("/common.properties", "base.url")
                .getProperty("base.url");

        driver.get(baseUrl);
        return new HomePage(driver);
    }

    public AuthPage goAuthPage(WebDriver driver){
           return goHomePage(driver)
                                    .clickEnterLink()
                                    .clickRegisterLink();
    }

    public TabletsPage goTabletsPage(WebDriver driver){
        return goHomePage(driver).clickTabletsLink();
    }

    public TabletPage goTabletPage(WebDriver driver){
        return goHomePage(driver).clickTabletLink();
    }
}
