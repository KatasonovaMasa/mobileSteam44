package tests;

import config.AuthorizationConfig;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidSearchTests extends TestBase {
    static AuthorizationConfig config = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());
    @Test
    @Tag("android")
    @Order(1)
    @Feature("Автотесты на мобилке")
    @Story("Авторизация")
    @Owner("Катасонова Мария")
    @DisplayName("Авторизация в приложении")
    void openApp() {
        step("Авторизация", () -> {
            $$(AppiumBy.className("android.widget.EditText")).get(0).click();
            $$(AppiumBy.className("android.widget.EditText")).get(0).sendKeys(config.login());
            $$(AppiumBy.className("android.widget.EditText")).get(1).click();
            $$(AppiumBy.className("android.widget.EditText")).get(1).sendKeys(config.password());
            $$(AppiumBy.className("android.view.ViewGroup")).get(4).click();
            sleep(15000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(3).shouldHave(visible);
        });
    }

    @Test
//    @Tag("android")
    @Order(2)
    @Feature("Автотесты на мобилке")
    @Story("Раздел Игр")
    @Owner("Катасонова Мария")
    @DisplayName("Кнопка поиска игр")
    void searchJobApi() {
        step("Поиск игры", () -> {
            $$(AppiumBy.className("android.view.ViewGroup")).get(1).click();
            $(AppiumBy.className("android.widget.EditText")).sendKeys("Cuphead" + "\n");
            $(AppiumBy.className("android.widget.ImageView")).click(); //нажать на вопрос
            $$(AppiumBy.className("android.view.ViewGroup")).get(2).click(); // нажать назад
            $$(AppiumBy.className("android.view.ViewGroup")).get(1).click(); //нажать на поиск
            sleep(1000);
            $(AppiumBy.xpath("//android.view.View[@content-desc=\"Cuphead 29 Sep, 2017 419 pуб.\"]")).shouldHave(visible);
        });
    }
}