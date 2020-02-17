package ua.ek.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class MapCasesList extends BasePage {

@FindBy(xpath = ".//td[@class='list-filter-param']/a")
private WebElement textPricesField;

    public MapCasesList(WebDriver driver) {
        super(driver);
    }

    public String getTextPrices(){
        return getWebElementText(textPricesField);
    }
}