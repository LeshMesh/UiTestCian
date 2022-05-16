package ru.cian;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.cian.pages.CianPage;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    CianPage cianPage = new CianPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://cian.ru";
        Configuration.browser = "CHROME";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void beforeEach() {
        open("/");
        sleep(2000); //обход защиты
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
