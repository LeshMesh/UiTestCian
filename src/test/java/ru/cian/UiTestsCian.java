package ru.cian;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class UiTestsCian extends TestBase {

    @Test
    void authorizationToEmailTest() {
        cianPage.clickLogInHeader()
                .setValueEmail()
                .setValuePassword()
                .clickContinueLogIn()

                .checkResultAuthorization();
    }

    @Test
    void searchListRentHousePriceCityTest() {
        cianPage.chooseFilterType()
                .chooseFilterOffer()
                .chooseFilterPrice()
                .chooseFilterGeo()
                .clickSearch()

                .checkResultSearch();
    }

    @Test
    void addFavoritesAuthorizationTest() {
        cianPage.choosePopularTab()
                .saveName()
                .clickAddFavorite()
                .checkAddFavoriteTooltip()
                .clickLogInFavorite()
                .openPageFavorites()
                .openFavoriteCard();
        switchTo().window(1);

        cianPage.checkResultAddFavourite();
    }

    @Test
    void addFavoritesTest() {
        cianPage.choosePopularTab()
                .saveName()
                .clickAddFavorite()
                .checkAddFavoriteTooltip()
                .openTooltipHeaderFavourite()

                .checkResultAddFavouriteTooltipHeader();
    }

    @Test
    void changeGeoTest() {
        cianPage.clickGeoSwitcher()
                .chooseCity()

                .checkChangeGeo();
    }

    @Test
    void promoLinkTest() {
        cianPage.openPromoCard()

                .checkMainFilter()
                .checkHeaderPage();
    }
}
