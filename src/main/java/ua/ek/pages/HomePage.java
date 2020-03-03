package ua.ek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.utils.PropertyReader;

public class HomePage extends BasePage {

    private String baseUrl;

    @FindBy(xpath = ".//div[@class='cr-contr']/div/em")
    private WebElement deliveryRegionLink;

    @FindBy(xpath = ".//span[@class='wu_entr']//em")
    private WebElement enterLink; // "Войти" link

    @FindBy(xpath = ".//ul[contains(@class,'mainmenu-list')]/li/a[contains(text(),'Компьютеры')]")
    private WebElement computersLink; // Menu "Компьютеры"

    @FindBy(xpath = "(.//div[@class='mainmenu-sublist']/a[@class='mainmenu-subitem mainmenu-icon30'])[1]")
    private WebElement tabletsLink; // SubMenu "Планшеты"

    @FindBy(xpath = ".//*[@id='li_br116']/label") // Apple
    private WebElement manufacturerApple;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //    public HomePage goHomePage(WebDriver driver){
//
//        String baseUrl = PropertyReader
//                .from("/properties/common.properties", "base.url")
//                .getProperty("base.url");
//
//        driver.get(baseUrl);
//        return new HomePage(driver);
//    }

    public String getBaseUrl(){
        return PropertyReader
                .from("/properties/common.properties", "base.url")
                .getProperty("base.url");
    }

    public WebElement getDeliveryRegionLink() {
        return deliveryRegionLink;
    }

    public WebElement getEnterLink() {
        return enterLink;
    }

    public WebElement getComputersLink() {
        return computersLink;
    }

    public WebElement getTabletsLink() {
        return tabletsLink;
    }

    public WebElement getManufacturerApple() {
        return manufacturerApple;
    }
}