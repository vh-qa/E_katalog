package ua.ek.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomWaits {

    public static ExpectedCondition<Boolean> isElementContainsText(WebElement webElement, String text) {
        return new WebElementContainsTextCondition(webElement, text);
    }

    static class WebElementContainsTextCondition implements ExpectedCondition<Boolean> {

        WebElement webElement;
        String text;

        public WebElementContainsTextCondition(WebElement webElement, String text) {
            this.webElement = webElement;
            this.text = text;
        }

        @Override
        public Boolean apply(WebDriver driver) {
            try {
                return webElement.getText().contains(text);
            } catch (StaleElementReferenceException | NoSuchElementException | TimeoutException e) {
                return false;
            }
        }
    }
}