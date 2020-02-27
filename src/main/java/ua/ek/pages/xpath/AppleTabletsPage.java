package ua.ek.pages.xpath;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ek.base.BasePage;
import ua.ek.utils.CustomWaits;

public class AppleTabletsPage extends BasePage {

    @FindBy(xpath = ".//*[@id='li_br116']/label")
    private WebElement manufacturerApple;

    @FindBy(xpath = ".//*[@id='tt-info']/a")
    private WebElement showButton;

    //  @FindBy(xpath = ".//div[@class='page-title']/h1[@class='t2' and contains(text(), '%s')]")
    @FindBy(xpath = ".//div[@class='page-title']/h1")
    private WebElement pageTitle;

    private String pageTitleXpath = ".//div[@class='page-title']/h1";

// Страница "Планшеты Apple"
// https://ek.ua/list/30/apple/
// Локаторы работают также для страниц с планшетами любого производителя

/*

1. contains
// Выбор всех описаний для камер для всех планшетов на странице

.//div[contains(@title,'Камера')]
.//div[contains(@class, 'm-s-f2')]/div[contains(@title,'Камера')]

2. starts-with
// Название планшетов
.//span[starts-with(text(),'%s')]

3. last
// Выбор последнего элемента в описании
.//div[contains(@class, 'm-s-f2')]/div[last()]

4. not
// Выбор элементов span, атрибут class которых не содержит слово 'mainmenu'
.//span[not (contains(@class, 'mainmenu'))]

5. or
// Элемент с title, который содержит слово 'Корпус' в описании планшета
.//div[contains(@title,'Камера35') or contains(@title,'Корпус')]

6. and
// Выбор элементов с названием планшета
.//div[@class='page-title']/h1[@class='t2' and contains(text(), '%s')]

7. ancestor
// Все предки div элемента с title, который содержит слово 'Корпус' в описании
.//div[contains(@title,'Корпус')]/ancestor::div

8. parent
// Родительский div по отношению к div с title, которые содержит слово 'Камера'
.//div[contains(@class, 'm-s-f2')]/div[contains(@title,'Камера')]

9. preceding
// Множество предков элементов с title, которые содержит слово 'Камера'
// эти предки table
.//div[contains(@class, 'm-s-f2')]/div[contains(@title,'Камера')]/preceding::table

10. preceding-sibling
// Названия сайтов магазинов, где продается данная модель планшета
.//span[@class='model-shop-city']/preceding-sibling::u

11. descendant
// Выбор всех описаний для камер для всех планшетов на странице
descendant::div[contains(@title,'Камера')]

// Все названия технических характеристик в описании планшета
// Экран, Память, Камера, Hardware, Аккумулятор (если есть), Корпус
.//div[contains(@class,'m-s-f2')]/descendant::div/span

12. following-sibling
// Стикер, который содержит слово 'процессор'
.//div[contains(@class, 'm-s-f2')]/parent::div//following-sibling::a[contains(text(),'процессор')]

13. text
// Элементы с названием магазина
.//u[contains(text(),'%s')]

14. count
// Ссылки с текстом названия магазина
.//a[count(u[contains(text(),'%s')])]

15. |

// Элементы с title, которые содержит слово 'Камера' и слово 'Корпус' в описании планшета
.//div[contains(@title,'Камера')] | .//div[contains(@title,'Корпус')]


16. >=

// Количество элентов 'a' внутри 'div'
.//div[count(a) >= 10]

17.  <=

// Количество элентов 'table' внутри 'div'
.//div[count(table) > 0 and count(table) <=1]

18. mod

// Количество элементов 'a' внутри 'div'
.//div[count(a) >= 31 mod 21]

*/
    public AppleTabletsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAppleManufacturerCheckBox() {
        return manufacturerApple;
    }

    public AppleTabletsPage clickShowButton() {

        // Explicit wait
        elementToBeClickable(TEN_SECONDS, showButton);
        executeWebElement(showButton);

        return new AppleTabletsPage(driver);
    }

    public String getPageTitleText() {

        // Fluent wait
        WebElement webElementFluentWay = fluentWait(By.xpath(pageTitleXpath), FIVE_SECONDS, MILLISECOND_500);

        // Custom wait
        WebElement webElementCustomWait = waitUntilElementIsVisible(FIVE_SECONDS, By.xpath(pageTitleXpath));
        WebDriverWait wait = new WebDriverWait(driver, FIVE_SECONDS);
        wait.until(CustomWaits.isElementContainsText(webElementCustomWait, "Apple"));

        return webElementCustomWait.getText();
    }
}