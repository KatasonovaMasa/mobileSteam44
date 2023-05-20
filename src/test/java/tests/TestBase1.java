package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBase1 {

    @BeforeAll
    public static void setup() {
            Configuration.browser = LocalDriver.class.getName();
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
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        Attach.addVideo(sessionId);
    }
}
