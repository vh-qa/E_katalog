package ua.ek.utils;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomWaits {

    public static ExpectedCondition<Boolean> isElementContainsText(String xpath, String text) {
        return new WebElementContainsTextCondition(xpath, text);
    }

    static class WebElementContainsTextCondition implements ExpectedCondition<Boolean> {

        String xpath;
        String text;

        public WebElementContainsTextCondition(String xpath, String text) {
            this.xpath = xpath;
            this.text = text;
        }

        @NullableDecl
        @Override
        public Boolean apply(@NullableDecl WebDriver driver) {

            try {
                WebElement webElement = driver.findElement(By.xpath(xpath));

                if (webElement.getText().contains(text)) {
                    return true;
                } else {
                    return false;
                }
            } catch (StaleElementReferenceException | NoSuchElementException | TimeoutException e) {
                return false;
            }
        }
    }
}