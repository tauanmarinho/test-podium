package com.podium.test;

import com.podium.test.driver.SetupDriver;
import org.openqa.selenium.WebDriver;

public abstract class UiBaseTest {

    private static WebDriver webDriver;
    private static final String BROWSER = System.getProperty("browser");
    private static SetupDriver setupDriver;

    static {
        setWebDriver();
    }

    private static void setWebDriver() {
        setupDriver = new SetupDriver(BROWSER, "Linux", "", "");
    }

    private static void loadWebDriver() {
        webDriver = setupDriver.getDriver();
    }
}
