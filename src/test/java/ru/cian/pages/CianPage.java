package ru.cian.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class CianPage {
    public String name;

    public CianPage clickLogInHeader() {
        $(byText("Войти")).click();
        return this;
    }

    public CianPage setValueEmail() {
        $("[data-name=SwitchToEmailAuthBtn]").click();
        $("[name=username]").setValue("ivlex_37rus@mail.ru");
        return this;
    }

    public CianPage setValuePassword() {
        $("[data-name=ContinueAuthBtn]").click();
        $("[name=password]").setValue("1234567890");
        return this;
    }

    public CianPage clickContinueLogIn() {
        $("[data-name=ContinueAuthBtn]").click();
        return this;
    }

    public CianPage checkResultAuthorization() {
        $("[data-name=UserAvatar]").shouldBe(Condition.visible).click();
        $("[data-name=UserMenuItem]").shouldHave(Condition.text("Личный кабинет"));
        return this;
    }

    public CianPage chooseFilterType() {
        $("[data-name=FiltersTabs]").$(byText("Снять")).click();
        return this;
    }

    public CianPage chooseFilterOffer() {
        $("[data-mark=FilterOfferType]").click();
        $(withTagAndText("span","Дом, дача")).click();
        return this;
    }

    public CianPage chooseFilterPrice() {
        $("[data-mark=FilterPrice]").click();
        $("[placeholder=от]").setValue("100000");
        $("[placeholder=до]").setValue("300000");
        return this;
    }

    public CianPage chooseFilterGeo() {
        $("#geo-suggest-input").setValue("Санкт-Петербург");
        $("[data-group=cities]").$("[title=Санкт-Петербург]").click();
        return this;
    }

    public CianPage clickSearch() {
        $("[data-mark=FiltersSearchButton]").click();
        return this;
    }

    public CianPage checkResultSearch() {
        $("#mainFilter_price").shouldHave(Condition.text("100 - 300 тыс ₽"));
        $("div h1").shouldHave(Condition.text("Снять дом в Санкт-Петербурге на длительный срок"));
        return this;
    }

    public CianPage choosePopularTab() {
        $("[data-name=PopularContent]").$("[data-name=Link]");
        sleep(2000);
        $("[data-name=PopularContent]").$("[data-name=Link]").click();
        return this;
    }

    public CianPage saveName() {
        name = $("[data-name=OfferTitle] h1").innerText();
        return this;
    }

    public CianPage clickAddFavorite() {
        $("[data-name=FavoriteButton]").click();
        return this;
    }

    public CianPage checkAddFavoriteTooltip() {
        $("[data-name=LoginMotivationTooltip]").shouldHave(Condition.text("Добавлено в избранное"));
        return this;
    }

    public CianPage clickLogInFavorite() {
        $(withTagAndText("span","Войти")).click();
        return this;
    }

    public CianPage openPageFavorites() {
        open("/favorites");
        return this;
    }

    public CianPage openFavoriteCard() {
        $("[data-name=MainTitle]").click();
        return this;
    }

    public CianPage checkResultAddFavourite() {
        $("[data-name=OfferTitle]").$("h1").shouldHave(Condition.text(name));
        return this;
    }

    public CianPage openTooltipHeaderFavourite() {
        $("[data-name=UtilityFavoritesContainer]").click();
        return this;
    }

    public CianPage checkResultAddFavouriteTooltipHeader() {
        $("[data-name=FavoriteItem span]").shouldHave(Condition.text(name));
        return this;
    }

    public CianPage clickGeoSwitcher() {
        $("[data-name=GeoSwitcher] button").click();
        return this;
    }

    public CianPage chooseCity() {
        $("[data-name=GeoSwitcherBody]").$(byText("Уфа")).click();
        $("[data-name=GeoSwitcherHeader]").$(byText("Выбрать")).click();
        return this;
    }

    public CianPage checkChangeGeo() {
        $("[data-name=GeoSwitcher]").shouldHave(Condition.text("Уфа"));
        return this;
    }

    public CianPage openPromoCard() {
        $("[data-name=PromoLinks]").$(byText("1-комнатные")).click();
        return this;
    }

    public CianPage checkMainFilter() {
        $("#mainFilter_dealType").shouldHave(Condition.text("Купить"));
        $("#mainFilter_roomType").shouldHave(Condition.text("1-комнатную"));
        return this;
    }

    public CianPage checkHeaderPage() {
        $("div h1").shouldHave(Condition.text("Продажа однокомнатных квартир в Москве"));
        return this;
    }
}
