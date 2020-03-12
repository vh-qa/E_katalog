package ua.ek.pages.tablets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class TabletsPage extends BasePage {

    // Manufacturers
    @FindBy(xpath = ".//*[@id='li_br116']/label")
    private WebElement manufacturerApple;

    @FindBy(xpath = ".//*[@id='li_br1364']/label/a")
    private WebElement manufacturerGoogle;

    @FindBy(xpath = ".//*[@id='li_br147']/label/a")
    private WebElement manufacturerSamsung;

    // Display diagonals
    @FindBy(xpath = ".//label[@for='c5699']")
    private WebElement displayDiagonal10inch;

    // Operating systems
    @FindBy(xpath = ".//label[@for='c36034']/a")
    private WebElement operatingSystemAndroid9Pie;

    @FindBy(xpath = ".//label[@for='c3871']/a")
    private WebElement operatingSystemIos;

    // Internal memory
    @FindBy(xpath = ".//label[@for='c9535']/a")
    private WebElement internalMemory256Gb;

    @FindBy(xpath = ".//*[@id='tt-info']/a")
    private WebElement showButton;

    public TabletsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getManufacturerApple() {
        return manufacturerApple;
    }

    public WebElement getManufacturerGoogle() {
        return manufacturerGoogle;
    }

    public WebElement getManufacturerSamsung() {
        return manufacturerSamsung;
    }

    public WebElement getDisplayDiagonal10inch() {
        return displayDiagonal10inch;
    }

    public WebElement getOperatingSystemAndroid9Pie() {
        return operatingSystemAndroid9Pie;
    }

    public WebElement getOperatingSystemIos() {
        return operatingSystemIos;
    }

    public WebElement getInternalMemory256Gb() {
        return internalMemory256Gb;
    }

    public WebElement getShowButton() {
        return showButton;
    }
}