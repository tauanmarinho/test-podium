package com.podium.test;

import com.podium.test.components.Podium;
import com.podium.test.driver.SetupDriver;
import org.openqa.selenium.WebDriver;

public abstract class UiBaseTest {

    protected WebDriver webDriver;
    private static final String BROWSER = System.getProperty("browser");
    public static final String BASE_URL = "https://www.podium.com";
    protected static SetupDriver setupDriver;
    protected Podium podium;

    static {
        setWebDriver();
    }

    private static void setWebDriver() {
        setupDriver = new SetupDriver(BROWSER, "Linux", "http://0.0.0.0:4444");
    }
}
