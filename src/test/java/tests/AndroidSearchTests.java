package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class AndroidSearchTests extends TestBase1 {

    @Test
    @Tag("android")
    @DisplayName("Mobile wiki page search test by Android device")
    void successfulSearchTest() {
        step("Use search line and and type value", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Open first found article", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/view_card_header_title")).first().click();
        });
        step("Check that error page haven't opened", () -> {
            assertThat($(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_text")).isDisplayed()).isFalse();
        });
    }
}