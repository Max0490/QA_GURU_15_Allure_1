package Homework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTestIssue {

    String repo = "Allure_Report_QA_GURU";

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void issueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".form-control.js-site-search-focus.header-search-input.jump-to-field.js-jump-to-field").setValue(repo).submit();
        $(".repo-list-item.hx_hit-repo.d-flex.flex-justify-start.py-4.public.source .v-align-middle").click();

        $("#issues-tab").shouldHave(visible);
    }

}
