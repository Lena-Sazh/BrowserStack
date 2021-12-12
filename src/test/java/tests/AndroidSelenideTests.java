package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;


@Tag("selenide_android")
public class AndroidSelenideTests extends TestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Verify language in wikipedia android app")
    void verifyLanguageTest() {
        step("Click menu button", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Click setting button", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });
        step("Click language setting button", () -> {
            String language = $(MobileBy.xpath("//*[@text='English']")).getAttribute("text");
            Assertions.assertEquals(language, "English");
        });
    }

}