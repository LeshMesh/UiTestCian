package ru.cian;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

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
    void searchListRentHousePriceCityTest() {
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

    @Test
    void addFavoritesAuthorizationTest() {
        open("/");
        $("[data-name=PopularContent]").$("[data-name=Link]").click();
        String name = $("[data-name=OfferTitle] h1").innerText();
        $("[data-name=FavoriteButton]").click();
        $("[data-name=LoginMotivationTooltip]").shouldHave(Condition.text("Добавлено в избранное"));
        $(withTagAndText("span","Войти")).click();

        $("[data-name=SwitchToEmailAuthBtn]").click();
        $("[name=username]").setValue("ivlex_37rus@mail.ru");
        $("[data-name=ContinueAuthBtn]").click();
        $("[name=password]").setValue("1234567890").pressEnter();
        $("[data-name=ContinueAuthBtn]").click();

        open("/favorites");
        $("[data-name=MainTitle]").click();
        switchTo().window(1);
        $("[data-name=OfferTitle]").$("h1").shouldHave(Condition.text(name));
    }

    @Test
    void addFavoritesTest() {
        open("/");
        $("[data-name=PopularContent]").$("[data-name=Link]").click();
        String name = $("[data-name=OfferTitle] h1").innerText();
        $("[data-name=FavoriteButton]").click();
        $("[data-name=LoginMotivationTooltip]").shouldHave(Condition.text("Добавлено в избранное"));
        $("[data-name=UtilityFavoritesContainer]").click();

        $("[data-name=FavoriteItem]").shouldHave(Condition.text(name));
    }

    @Test
    void changeGeoTest() {
        open("/");
        $("[data-name=GeoSwitcher] button").click();
        $("[data-name=GeoSwitcherBody]").$(byText("Уфа")).click();
        $("[data-name=GeoSwitcherHeader]").$(byText("Выбрать")).click();

        $("[data-name=GeoSwitcher]").shouldHave(Condition.text("Уфа"));
    }

    @Test
    void linkTest() {
        open("/");
        $("[data-name=PromoLinks]").$(byText("1-комнатные")).click();

        $("#mainFilter_dealType").shouldHave(Condition.text("Купить"));
        $("#mainFilter_roomType").shouldHave(Condition.text("1-комнатную"));
        $("div h1").shouldHave(Condition.text("Продажа однокомнатных квартир в Москве"));
    }
}
