package com.podium.test.components;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseWebComponent {

    private static final long DEFAULT_SLEEP_TIMEOUT = 125L;

    protected static WebDriver webDriver;
    private final long defaultTimeOut;

    protected BaseWebComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        defaultTimeOut = 30;
    }

    protected void waitFor(long waitTimeMs) {
        try {
            Thread.sleep(waitTimeMs);
        } catch (InterruptedException var3) {
            throw new RuntimeException("Bad sleep in tinyWait().", var3);
        }
    }

    protected boolean isClickable(WebElement element) {
        try {
            new WebDriverWait(webDriver, 2).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (WebDriverException ex) {
            return false;
        }
    }

    protected void waitAndClick(WebElement webElement) {
        waitForVisible(webElement);
        waitForClickable(webElement);
        long timeInMilliseconds = 0;
        long timeOutInMilliseconds = defaultTimeOut * 1000;

        WebDriverException exceptionToThrow = new WebDriverException();

        while (timeInMilliseconds < timeOutInMilliseconds) {
            try {
                webElement.click();
                exceptionToThrow = null;
                break;
            } catch (WebDriverException e) {
                exceptionToThrow = e;
                waitFor(DEFAULT_SLEEP_TIMEOUT);
                timeInMilliseconds += DEFAULT_SLEEP_TIMEOUT;
            }
        }
        if (exceptionToThrow != null) {
            throw exceptionToThrow;
        }
    }

    protected void waitAndClick(By by) {
        waitAndClick(findElement(by));
    }

    protected void waitForClickable(By by) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void waitForClickable(WebElement element) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForClickable(WebElement element, int timeOut) {
        new WebDriverWait(webDriver, timeOut)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForVisible(By by) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected void waitForVisible(WebElement element) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForVisible(WebElement element, long timeout) {
        new WebDriverWait(webDriver, timeout)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForVisible(List<WebElement> elements) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void waitForInvisible(WebElement element) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForInvisible(By by) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void waitForInvisibleWhilePresent(WebElement element) {
        new WebDriverWait(webDriver, 300)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForSelected(WebElement element) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.elementToBeSelected(element));
    }

    protected void waitForRefresh(WebElement element) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(element)));
    }

    protected void waitForRefresh(List<WebElement> elements) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions
                        .refreshed(ExpectedConditions.invisibilityOfAllElements(elements)));
    }

    protected void waitForChangeToVisible(WebElement element) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

    protected void waitForFilledAttribute(WebElement element, String attribute, String value) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    protected void waitForNotNullAttribute(WebElement element, String attribute) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    protected void waitForIFrameAndSwitchDefault(WebElement element) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    protected void waitForIFrameAndSwitch(String frame) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    protected boolean isElementEnabled(By by) {
        WebElement element = findElement(by);
        return element.isEnabled();
    }

    protected boolean isElementDisplayed(By by) {
        WebElement element = findElement(by);
        return element.isDisplayed();
    }

    protected boolean isElementSelected(By by) {
        WebElement element = findElement(by);
        return element.isSelected();
    }

    protected void sendKeys(By by, CharSequence keys) {
        WebElement element = findElement(by);
        element.sendKeys(keys);
    }

    protected void sendKeys(WebElement element, CharSequence keys) {
        element.sendKeys(keys);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void click(By by) {
        WebElement element = findElement(by);
        click(element);
    }

    protected WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    protected void moveAndClick(WebElement element) {
        Actions act = new Actions(webDriver);
        act.moveToElement(element).click().build().perform();
    }
}
