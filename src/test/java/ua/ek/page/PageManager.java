package ua.ek.page;

import org.openqa.selenium.WebDriver;
import ua.ek.base.BasePage;
import ua.ek.utils.PropertyReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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

    public MapCasesPage goMapCasesPage(WebDriver driver){
        return goHomePage(driver).clickMapCasesLink();
    }

    public MapCasePage goMapCasePage(WebDriver driver){
        return goHomePage(driver).clickMapCaseLink();
    }
}
