package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import drivers.BrowserstackDriver;
import helpers.Attach;
import helpers.Browserstack;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.selenide.AllureSelenide;
import io.appium.java_client.AppiumDriver;
import org.jbehave.core.annotations.Given;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;

import java.net.URL;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBaseBrowserstack {
    @BeforeAll
    public static void setup() {
            Configuration.browser = BrowserstackDriver.class.getName();
            Configuration.browserSize = null;

        }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId().toString();
        closeWebDriver();
        Attach.addVideo(sessionId);
    }

}
