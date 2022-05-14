package ru.cian;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UiTestsCian extends TestBase {

    @Test
    void authorizationToEmailTest() {
        open("/");
        $(byText("Войти")).click();
        $("[data-name=SwitchToEmailAuthBtn]").click();
        $("[name=username]").setValue("ivlex_37rus@mail.ru");
        $("[data-name=ContinueAuthBtn]").click();
        $("[name=password]").setValue("1234567890").pressEnter();
        $("[data-name=ContinueAuthBtn]").click();

        $("[data-name=UserAvatar]").shouldBe(Condition.visible).click();
        $("[data-name=UserMenuItem]").shouldHave(Condition.text("Личный кабинет"));
    }

    @Test
    void search() {
        open("/");
        $("[data-name=FiltersTabs]").$(byText("Снять")).click();
        $("[data-mark=FilterOfferType]").click();
        $(withTagAndText("span","Дом, дача")).click();
        $("[data-mark=FilterPrice]").click();
        $("[placeholder=от]").setValue("100000");
        $("[placeholder=до]").setValue("300000");
        $("#geo-suggest-input").setValue("Санкт-Петербург");
        $("[data-group=cities]").$("[title=Санкт-Петербург]").click();
        $("[data-mark=FiltersSearchButton]").click();

        $("#mainFilter_price").shouldHave(Condition.text("100 - 300 тыс ₽"));
        $("div h1").shouldHave(Condition.text("Снять дом в Санкт-Петербурге на длительный срок"));
    }
}
