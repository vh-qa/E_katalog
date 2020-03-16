package ua.ek.pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = ".//h1[@class='t2']/b[@class='hst']")
    private WebElement searchListTitleElement;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchListTitleElement() {
        return searchListTitleElement;
    }
}