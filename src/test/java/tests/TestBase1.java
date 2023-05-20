package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.addVideo;
import static io.qameta.allure.Allure.step;

public class TestBase1 {

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
        //  Attach.screenshotAs("Last screenshot");
        // Attach.pageSource();
        closeWebDriver();
        Attach.addVideo(sessionId);
//        if (System.getProperty("local").equals("browserstack")) {
//            Attach.addVideo(sessionId);
//        }
    }
}
