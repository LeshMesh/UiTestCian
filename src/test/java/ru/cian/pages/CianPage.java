package ru.cian.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static ru.cian.TestData.*;

public class CianPage {
    public String name;

    public SelenideElement
        buttonLogIn = $(byText("Войти")),
        buttonEmail = $("[data-name=SwitchToEmailAuthBtn]"),
        fieldEmail = $("[name=username]"),
        buttonContinue = $("[data-name=ContinueAuthBtn]"),
        fieldPassword = $("[name=password]"),
        userAvatar = $("[data-name=UserAvatar]"),
        userMenu = $("[data-name=UserMenuItem]"),
        tabsRent = $("[data-name=FiltersTabs]").$(byText("Снять")),
        filterOffer = $("[data-mark=FilterOfferType]"),
        house = $(withTagAndText("span","Дом, дача")),
        filterPriceSearch = $("[data-mark=FilterPrice]"),
        fieldPriceFrom = $("[placeholder=от]"),
        fieldPriceTo = $("[placeholder=до]"),
        fieldInputGeo = $("#geo-suggest-input"),
        selectCity = $("[data-group=cities]").$("[title=" + city + "]"),
        buttonSearch = $("[data-mark=FiltersSearchButton]"),
        filterPrice = $("#mainFilter_price"),
        headerPage = $("div h1"),
        popularTab = $("[data-name=PopularContent]").$("[data-name=Link]"),
        nameTab = $("[data-name=OfferTitle] h1"),
        buttonFavourite = $("[data-name=FavoriteButton]"),
        nameFavouriteTooltip = $("[data-name=LoginMotivationTooltip]"),
        headerTab = $("[data-name=MainTitle]"),
        headerFavouriteTooltip = $("[data-name=UtilityFavoritesContainer]"),
        nameFavouriteTab = $("[data-name=FavoriteItem span]"),
        buttonGeoSwitcher = $("[data-name=GeoSwitcher] button"),
        inputGeo = $("[data-name=GeoSwitcherBody]").$(byText(city)),
        buttonSelectGeo = $("[data-name=GeoSwitcherHeader]").$(byText("Выбрать")),
        promoLinks = $("[data-name=PromoLinks]").$(byText("1-комнатные")),
        filterType = $("#mainFilter_dealType"),
        filterRoomType = $("#mainFilter_roomType"),
        buttonLogInTooltip = nameFavouriteTooltip.$(byText("Войти")),
        titleTab = $("[data-name=OfferTitle]").$("h1");

    public CianPage clickLogInHeader() {
        buttonLogIn.click();
        return this;
    }

    public CianPage setValueEmail() {
        buttonEmail.click();
        fieldEmail.setValue("ivlex_37rus@mail.ru");
        return this;
    }

    public CianPage setValuePassword() {
        buttonContinue.click();
        fieldPassword.setValue("1234567890");
        return this;
    }

    public CianPage clickContinueLogIn() {
        buttonContinue.click();
        return this;
    }

    public CianPage checkResultAuthorization() {
        userAvatar.shouldBe(Condition.visible).click();
        userMenu.shouldHave(Condition.text("Личный кабинет"));
        return this;
    }

    public CianPage chooseFilterType() {
        tabsRent.click();
        return this;
    }

    public CianPage chooseFilterOffer() {
        filterOffer.click();
        house.click();
        return this;
    }

    public CianPage chooseFilterPrice() {
        filterPriceSearch.click();
        fieldPriceFrom.setValue(priceFrom);
        fieldPriceTo.setValue(priceTo);
        return this;
    }

    public CianPage chooseFilterGeo() {
        fieldInputGeo.setValue(city);
        selectCity.click();
        return this;
    }

    public CianPage clickSearch() {
        buttonSearch.click();
        return this;
    }

    public CianPage checkResultSearch() {
        filterPrice.shouldHave(Condition.text(priceFromShort + " - " + priceToShort + " тыс ₽"));
        headerPage.shouldHave(Condition.text("Снять дом в " + city));
        return this;
    }

    public CianPage choosePopularTab() {
        popularTab.click();
        return this;
    }

    public CianPage saveName() {
        name = nameTab.innerText();
        return this;
    }

    public CianPage clickAddFavorite() {
        buttonFavourite.click();
        return this;
    }

    public CianPage checkAddFavoriteTooltip() {
        nameFavouriteTooltip.shouldHave(Condition.text("Добавлено в избранное"));
        return this;
    }

    public CianPage clickLogInFavorite() {
        buttonLogInTooltip.click();
        return this;
    }

    public CianPage openPageFavorites() {
        open("/favorites");
        return this;
    }

    public CianPage openFavoriteCard() {
        headerTab.click();
        return this;
    }

    public CianPage checkResultAddFavourite() {
        titleTab.shouldHave(Condition.text(name));
        return this;
    }

    public CianPage openTooltipHeaderFavourite() {
        headerFavouriteTooltip.click();
        return this;
    }

    public CianPage checkResultAddFavouriteTooltipHeader() {
        nameFavouriteTab.shouldHave(Condition.text(name));
        return this;
    }

    public CianPage clickGeoSwitcher() {
        buttonGeoSwitcher.click();
        return this;
    }

    public CianPage chooseCity() {
        inputGeo.click();
        buttonSelectGeo.click();
        return this;
    }

    public CianPage checkChangeGeo() {
        buttonGeoSwitcher.shouldHave(Condition.text(city));
        return this;
    }

    public CianPage openPromoCard() {
        promoLinks.click();
        return this;
    }

    public CianPage checkMainFilter() {
        filterType.shouldHave(Condition.text("Купить"));
        filterRoomType.shouldHave(Condition.text("1-комнатную"));
        return this;
    }

    public CianPage checkHeaderPage() {
        headerPage.shouldHave(Condition.text("Продажа однокомнатных квартир в Москве"));
        return this;
    }
}
