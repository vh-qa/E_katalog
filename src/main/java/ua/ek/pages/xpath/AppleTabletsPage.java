package ua.ek.pages.xpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class AppleTabletsPage extends BasePage {

    @FindBy(xpath = ".//*[@id=\"li_br116\"]/label")
    private WebElement manufacturerApple;

    @FindBy(xpath = ".//*[@id=\"tt-info\"]/a")
    private WebElement showButton;

    @FindBy(xpath=".//div[@class='page-title']/h1[@class='t2' and contains(text(), 'Apple')]")
    private WebElement pageTitle;


//  Страница "Планшеты Apple"
//   https://ek.ua/list/30/apple/

/*

1. contains
// Выбор всех описаний для камер для всех планшетов на странице

.//div[contains(@title,'Камера')]
.//div[contains(@class, 'm-s-f2')]/div[3]
.//div[contains(@class, 'm-s-f2')]/child::div[3]
.//div[contains(@class, 'm-s-f2')]/div[contains(@title,'Камера')]
.//table[@class='model-short-block']//div[@class='model-short-description']/div[contains(@class, 'm-s-f2')]/div[3]

// Выбор описания для камеры пятого по номеру планшета на странице
".//form[@id='list_form1']/div[5]//div[contains(@title, 'Камера')]")

2. starts-with
// Название планшетов
.//span[starts-with(text(),'Apple')]

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
.//div[@class='page-title']/h1[@class='t2' and contains(text(), 'Apple')]

7. ancestor
// Все предки div элемента с title, который содержит слово 'Корпус' в описании
.//div[contains(@title,'Корпус')]/ancestor::div

8. parent
// Третий по счету стикер в описании планшета
.//div[contains(@class, 'm-s-f2')]/parent::div/div/a/following-sibling::a[2]

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
// Третий по счету стикер в описании планшета
.//div[contains(@class, 'm-s-f2')]/parent::div/div/a/following-sibling::a[2]

13. text
// Элементы с названием магазина 'Eldorado'
.//u[contains(text(),'Eldorado')]

14. count
// Ссылки с текстом названия магазина 'Eldorado'
.//a[count(u[contains(text(),'Eldorado')])]

// div, которые содержат table
.//div[count(table)]

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

    public WebElement getAppleManufacturerCheckBox(){
        return manufacturerApple;
    }

    public AppleTabletsPage clickShowButton() {
        waitUntilElementIsVisible(FIVE_SECONDS, showButton);
        executeWebElement(showButton);

        return new AppleTabletsPage(driver);
    }

    public String getPageTitleText(){
        return getWebElementText(pageTitle);
    }
}