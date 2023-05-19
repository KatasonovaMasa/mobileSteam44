package tests;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidSearchTests extends TestBase {



    @Tag("SteamMobile")
    @Test
    @Order(1)
    @Feature("Автотесты на мобилке")
    @Story("Авторизация")
    @Owner("Катасонова Мария")
    @DisplayName("Авторизация в приложении")
    void openApp() {
        step("Авторизация", () -> {
            $$(AppiumBy.className("android.widget.EditText")).get(0).click();
            $$(AppiumBy.className("android.widget.EditText")).get(0).sendKeys("Test_quru");
            $$(AppiumBy.className("android.widget.EditText")).get(1).click();
            $$(AppiumBy.className("android.widget.EditText")).get(1).sendKeys("Mgbb4gas!)");
            $$(AppiumBy.className("android.view.ViewGroup")).get(4).click();
            sleep(15000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(3).shouldHave(visible);
        });
    }

    @Tag("SteamMobile")
    @Test
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

//    @Test
//    @Tag("android")
//    @DisplayName("Mobile wiki page search test by Android device")
//    void successfulSearchTest() {
//        step("Use search line and and type value", () -> {
//            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
//            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
//        });
//        step("Open first found article", () -> {
//            $$(AppiumBy.id("org.wikipedia.alpha:id/view_card_header_title")).first().click();
//        });
//        step("Check that error page haven't opened", () -> {
//            assertThat($(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_text")).isDisplayed()).isFalse();
//        });
//    }
}