package com.podium.test.driver;

import lombok.Getter;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Getter
public class SetupDriver {

    private WebDriver driver;
    private String browser;
    private String os;
    private String node;
    private String baseUrl;

    public SetupDriver(String browser, String os, String node, String baseUrl) {
        this.browser = browser;
        this.os = os;
        this.node = node;
        this.baseUrl = baseUrl;

        Platform platform = Platform.fromString(os.toLowerCase());
        if(browser.equalsIgnoreCase("chrome")) {
            capabilitiesChrome(node, platform);
        } else if (browser.equalsIgnoreCase("firefox")) {
            capabilitiesFirefox(node, platform);
        } else {
            try {
                throw new Exception("Not implemented for this browser");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        driverProperties(baseUrl);
    }

    private void driverProperties(String baseUrl) {
        this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get(baseUrl);
    }

    private void capabilitiesFirefox(String node, Platform platform) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("platform", platform);
        try {
            this.driver = new RemoteWebDriver(new URL(node + "/wd/hub"), firefoxOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void capabilitiesChrome(String node, Platform platform) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platform", platform);
        try {
            this.driver = new RemoteWebDriver(new URL(node + "/wd/hub"), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
