package com.todoist;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.todoist.helpers.Attach;
import com.todoist.helpers.DriverConfig;
import com.todoist.pages.LogInPage;
import com.todoist.pages.ProjectPage;
import com.todoist.pages.TaskPage;
import com.todoist.pages.TopFilterPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    LogInPage logInPage = new LogInPage();
    ProjectPage projectPage = new ProjectPage();
    TaskPage taskPage = new TaskPage();
    TopFilterPage topFilterPage = new TopFilterPage();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        DriverConfig.configure();
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
