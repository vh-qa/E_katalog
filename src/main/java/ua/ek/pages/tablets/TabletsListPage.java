package ua.ek.pages.tablets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class TabletsListPage extends BasePage {

@FindBy(xpath = ".//td[@class='list-filter-param']/a")
private WebElement textPricesField;

    public TabletsListPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTextPricesField(){
        return textPricesField;
    }
}