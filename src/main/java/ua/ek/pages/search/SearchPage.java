package ua.ek.pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class SearchPage extends BasePage {

    @FindBy(xpath = ".//input[@id='ek-search']")
    private WebElement searchField;

    @FindBy(xpath = ".//button[@name='search_but_']")
    private WebElement searchButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
