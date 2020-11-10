package com.podium.test;

import com.podium.test.driver.SetupDriver;
import org.openqa.selenium.WebDriver;

public abstract class UiBaseTest {

    private static WebDriver webDriver;
    private static final String BROWSER = System.getProperty("browser");

    static {
        loadWebDriver();
    }

    private static void loadWebDriver() {
        SetupDriver setupDriver = new SetupDriver(BROWSER, "Linux", "", "");
    }
}
