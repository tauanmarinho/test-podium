package com.podium.test;

import com.podium.test.components.Login;
import com.podium.test.components.Podium;
import com.podium.test.driver.SetupDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public abstract class UiBaseTest {

    protected static WebDriver webDriver;
    private static final String BROWSER = System.getProperty("browser");
    protected static final String BASE_URL = "https://www.podium.com";
    protected static SetupDriver setupDriver;
    protected Podium podium;

    static {
        setWebDriver();
        loadWebDriver();
    }

    public static void loadWebDriver() {
        webDriver = setupDriver.getDriver();
    }

    private static void setWebDriver() {
        setupDriver = new SetupDriver(BROWSER, "Linux", "http://0.0.0.0:4444");
    }

    @AfterSuite
    private void quitWebDriver() {
        this.webDriver.quit();
    }
}
