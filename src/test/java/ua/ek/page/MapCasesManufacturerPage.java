package ua.ek.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class MapCasesManufacturerPage extends BasePage {

    @FindBy(xpath = ".//div[@class='page-title']/h1[@class='t2']")
    private WebElement pageTitle;

    public MapCasesManufacturerPage(WebDriver driver){
        super(driver);
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }
}
