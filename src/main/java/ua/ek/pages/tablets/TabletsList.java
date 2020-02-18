package ua.ek.pages.tablets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class TabletsList extends BasePage {

@FindBy(xpath = ".//td[@class='list-filter-param']/a")
private WebElement textPricesField;

    public TabletsList(WebDriver driver) {
        super(driver);
    }

    public String getTextPrices(){
        return getWebElementText(textPricesField);
    }
}
