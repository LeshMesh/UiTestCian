package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.CianPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    CianPage cianPage = new CianPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://cian.ru";
        Configuration.browser = "CHROME";
        Configuration.browserSize = "1920x1080";
    }
}
