package Homework;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebStepsIssue {

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Поиск тестового репозитория {{repo}}")
    public void searchRepo(String repo) {
        $(".form-control.js-site-search-focus.header-search-input.jump-to-field.js-jump-to-field").setValue(repo).submit();
        $(".repo-list-item.hx_hit-repo.d-flex.flex-justify-start.py-4.public.source .v-align-middle").click();
    }

    @Step("Поиск меню Issue")
    public void searchIssue() {
        $("#issues-tab").shouldHave(visible);
    }


}
