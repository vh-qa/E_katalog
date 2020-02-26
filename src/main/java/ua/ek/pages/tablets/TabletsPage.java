package ua.ek.pages.tablets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class TabletsPage extends BasePage {

    private final static String APPLE = "apple";
    private final static String GOOGLE = "google";
    private final static String SAMSUNG = "samsung";
    private final static String LENOVO = "lenovo";

    private final static int TEN_INCH = 10;

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
    @FindBy(xpath = ".//label[@for='c36034']/a") // Android 9 Pie
    private WebElement operatingSystemAndroid9Pie;

    @FindBy(xpath = ".//label[@for='c3871']/a") // iOS
    private WebElement operatingSystemIos;

    // Internal memory
    @FindBy(xpath = ".//label[@for='c9535']/a")
    private WebElement internalMemory256Gb;

    @FindBy(xpath = ".//*[@id='tt-info']/a")
    private WebElement showButton;

    public TabletsPage(WebDriver driver) {
        super(driver);
    }

    public TabletsPage clickManufacturer(String manufacturerName) {

        switch (manufacturerName.trim().toLowerCase()) {
            case APPLE:
                clickManufacturer(manufacturerApple);
                break;
            case GOOGLE:
                clickManufacturer(manufacturerGoogle);
                break;
            case SAMSUNG:
                clickManufacturer(manufacturerSamsung);
                break;
            default:
                break;
        }

        return this;
    }

    public void clickManufacturer(WebElement webElement) {
        waitUntilElementIsVisible(FIVE_SECONDS, webElement);
        executeWebElement(webElement);
    }

    public TabletsPage clickDisplayDiagonal(int displayDiagonal) {
        switch (displayDiagonal) {
            case TEN_INCH:
                clickDisplayDiagonal(displayDiagonal10inch);
                break;
            default:
                break;
        }

        return this;
    }

    public void clickDisplayDiagonal(WebElement webElement) {
        waitUntilElementIsVisible(FIVE_SECONDS, webElement);
        executeWebElement(webElement);
    }

    public TabletsManufacturerPage clickShowButton() {
//        waitUntilElementIsVisible(FIVE_SECONDS, showButton);
        executeWebElement(showButton);

        return new TabletsManufacturerPage(driver);
    }
}