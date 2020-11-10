package com.podium.test.tests;

import com.podium.test.UiBaseTest;
import com.podium.test.components.Podium;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest extends UiBaseTest {

    @BeforeMethod
    private void loadWebDriver() {
        this.webDriver = setupDriver.getDriver();
         podium = new Podium(webDriver);
    }

    @Test
    public void test() throws InterruptedException {
        podium
                .navigateTo("https://www.podium.com");

        Thread.sleep(10000);
        Assert.assertEquals(true, true);
    }

    @AfterMethod
    private void quitWebDriver() {
        this.webDriver.quit();
    }
}
