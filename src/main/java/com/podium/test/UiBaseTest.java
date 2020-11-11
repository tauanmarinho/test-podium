package com.podium.test;

import com.podium.test.components.Podium;
import com.podium.test.driver.SetupDriver;
import org.openqa.selenium.WebDriver;

public abstract class UiBaseTest {

    private static final String BROWSER = System.getProperty("browser");
    protected static final String BASE_URL = "https://www.podium.com";

    public WebDriver loadWebDriver() {
        SetupDriver setupDriver = new SetupDriver(BROWSER, "Linux", "http://0.0.0.0:4444");
        return setupDriver.getDriver();
    }

    public void quitWebDriver(WebDriver webDriver) {
        webDriver.quit();
    }
}
