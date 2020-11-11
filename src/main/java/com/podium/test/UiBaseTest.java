package com.podium.test;

import com.podium.test.driver.SetupDriver;
import org.openqa.selenium.WebDriver;

public abstract class UiBaseTest {

    private static final String BROWSER = System.getProperty("browser");
    private static final String LOCAL_IP_ADDRESS = System.getProperty("localIpAddress");
    protected static final String BASE_URL = "https://www.podium.com";

    public WebDriver loadWebDriver() {
        SetupDriver setupDriver = new SetupDriver(BROWSER, "Linux", "http://" + LOCAL_IP_ADDRESS + ":4444");
        return setupDriver.getDriver();
    }

    public void quitWebDriver(WebDriver webDriver) {
        webDriver.quit();
    }
}
