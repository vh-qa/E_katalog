package ua.ek.utils;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitUtils {
    private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public Alert alertIsPresent(int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.alertIsPresent());
        } catch (NoAlertPresentException e) {
            return null;
        } catch (TimeoutException e) {
            return null;
        }
    }

    public Boolean elementSelectionStateToBe(By element, boolean selected, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean elementSelectionStateToBe(WebElement element, boolean selected, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement elementToBeClickable(By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("WebElement was not found");
        }
    }

    public WebElement elementToBeClickable(WebElement element, int timeout) throws RuntimeException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("WebElement was not found");
        }
    }

    public Boolean elementToBeSelected(By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.elementToBeSelected(element));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean elementToBeSelected(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.elementToBeSelected(element));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebDriver frameToBeAvailableAndSwitchToIt(By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public WebDriver frameToBeAvailableAndSwitchToIt(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public Boolean invisibilityOfTheElementLocated(By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean invisibilityOfElementWithText(By element, String text, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.invisibilityOfElementWithText(element, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public List<WebElement> presenceOfAllElementsLocatedBy(By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public WebElement presenceOfElementLocated(By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public Boolean textToBePresentInElement(WebElement element, String text, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean textToBePresentInElementLocated(By element, String text, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(element, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean textToBePresentInElementValue(By element, String text, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean titleIs(String title, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.titleIs(title));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean titleContains(String title, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement visibilityOf(WebElement element, int timeout) throws RuntimeException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("WebElement was not found");
        }
    }

    public List<WebElement> visibilityOfAllElements(List<WebElement> elements, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public List<WebElement> visibilityOfAllElementsLocatedBy(By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public WebElement visibilityOfElementLocated(By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public Boolean attributeContains(By element, String attribute, String value, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.attributeContains(element, attribute, value));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean attributeToBe(By element, String attribute, String value, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean attributeToBeNotEmpty(WebElement element, String attribute, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean invisibilityOf(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean javaScriptThrowsNoExceptions(String javaScript, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.javaScriptThrowsNoExceptions(javaScript));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Object jsReturnsValue(String javaScript, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.jsReturnsValue(javaScript));
        } catch (TimeoutException e) {
            return null;
        }
    }

/*
    public Boolean not(ExpectedCondition<?> condition, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.not(condition);
        } catch (TimeoutException e) {
            return false;
        }
    }
 */

    public List<WebElement> numberOfElementsToBe(By locator, int number, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.numberOfElementsToBe(locator, number));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public List<WebElement> numberOfElementsToBeLessThan(By locator, int number, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, number));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public List<WebElement> numberOfElementsToBeMoreThan(By locator, int number, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public Boolean numberOfWindowsToBe(int expectedNumberOfWindows, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement presenceOfNestedElementLocatedBy(By locator, By childLocator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(locator, childLocator));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public WebElement presenceOfNestedElementLocatedBy(WebElement element, By childLocator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, childLocator));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public List<WebElement> presenceOfNestedElementsLocatedBy(By parent, By childLocator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(parent, childLocator));
        } catch (TimeoutException e) {
            return null;
        }
    }

// refreshed method

    /*



     */


    public Boolean stalenessOf(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.stalenessOf(element));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean textMatches(By locator, java.util.regex.Pattern pattern, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.textMatches(locator, pattern));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean textToBe(By locator, String value, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.textToBe(locator, value));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean textToBePresentInElementValue(WebElement element, String text, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean urlContains(String text, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.urlContains(text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean urlMatches(String regex, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.urlMatches(regex));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean urlToBe(String url, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.urlToBe(url));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public List<WebElement> visibilityOfNestedElementsLocatedBy(By parent, By childLocator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parent, childLocator));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public List<WebElement> visibilityOfNestedElementsLocatedBy(WebElement element, By childLocator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element, childLocator));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public WebElement fluentWait(By element, int timeout, int polling) {
        WebElement webElement = null;

        try {
            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofMillis(polling))
                    .ignoring(StaleElementReferenceException.class);
            webElement = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(element));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("NoSuchElementException");
        } catch (ElementNotVisibleException e) {
            throw new ElementNotVisibleException("ElementNotVisibleException");
        } catch (TimeoutException e) {
            throw new TimeoutException("TimeoutException");
        }
        return webElement;
    }

    public static class CustomWait implements ExpectedCondition<Boolean> {

        String pageTitle;

        public CustomWait(String pageTitle) {
            this.pageTitle = pageTitle;
        }

        @NullableDecl
        @Override
        public Boolean apply(@NullableDecl WebDriver driver) {
            try {
                return driver.getTitle().contains(pageTitle);

            } catch (StaleElementReferenceException e) {
                return false;
            } catch (java.util.NoSuchElementException e) {
                return false;
            }catch(TimeoutException e){
                return false;
            }
        }
    }
}