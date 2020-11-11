package com.podium.test.components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebComponent {

    private static final long DEFAULT_SLEEP_TIMEOUT = 125L;

    protected static WebDriver webDriver;
    private final long defaultTimeOut;

    protected BaseWebComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        defaultTimeOut = 30;
    }

    protected void waitForClickable(WebElement element) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForVisible(WebElement element) {
        new WebDriverWait(webDriver, defaultTimeOut)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void sendKeys(WebElement element, CharSequence keys) {
        element.sendKeys(keys);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected WebElement findElement(By by) {
        return webDriver.findElement(by);
    }
}
