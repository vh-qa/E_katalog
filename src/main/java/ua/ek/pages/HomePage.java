package ua.ek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.utils.PropertyReader;

public class HomePage extends BasePage {

    @FindBy(xpath = ".//div[@class='cr-contr']/div/em")
    private WebElement deliveryRegionLink;

    @FindBy(xpath = ".//span[@class='wu_entr']//em")
    private WebElement enterLink;

    @FindBy(xpath = ".//div[@id='mui_user_login_window']/div[@style='display: block;']")
    private WebElement titleAuthRegistrationForm;

    @FindBy(xpath = ".//ul[contains(@class,'mainmenu-list')]/li/a[contains(text(),'Компьютеры')]")
    private WebElement computersMenuLink;

    @FindBy(xpath = "(.//div[@class='mainmenu-sublist']/a[@class='mainmenu-subitem mainmenu-icon30'])[1]")
    private WebElement tabletsSubMenuLink;

    @FindBy(xpath = ".//*[@id='li_br116']/label")
    private WebElement manufacturerApple;

    public HomePage(WebDriver driver) {
        super(driver);
    }

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

    public WebElement getComputersMenuLink() {
        return computersMenuLink;
    }

    public WebElement getTabletsSubMenuLink() {
        return tabletsSubMenuLink;
    }

    public WebElement getManufacturerApple() {
        return manufacturerApple;
    }
}