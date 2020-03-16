package ua.ek.pages.tablets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class TabletsListPage extends BasePage {

    @FindBy(xpath = ".//div[@class='page-title']/h1[@class='t2']")
    private WebElement tabletsListTitle;

    @FindBy(xpath = ".//td[@class='list-filter-param']/a")
    private WebElement stickerTextElement;

    public TabletsListPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTabletsListTitle() {
        return tabletsListTitle;
    }

    public WebElement getStickerTextElement() {
        return stickerTextElement;
    }
}