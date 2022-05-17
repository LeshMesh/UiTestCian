package ru.cian;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class UiTestsCian extends TestBase {

    @Test
    @DisplayName("Авторизация по Email")
    void authorizationToEmailTest() {
        step("Открываем форму авторизации", () ->
            cianPage.clickLogInHeader());
        step("Вводим Email и пароль", () -> {
            cianPage.setValueEmail()
                .setValuePassword()
                .clickContinueLogIn();
        });
        step("Проверяем успешную авторизацию", () ->
            cianPage.checkResultAuthorization());
    }

    @Test
    @DisplayName("Поиск аренды дома")
    void searchListRentHousePriceCityTest() {
        step("Выбираем фильтр Снять", () ->
            cianPage.chooseFilterType());
        step("Выбираем вид недвижимости", () ->
            cianPage.chooseFilterOffer());
        step("Устанавливаем стоимость", () ->
            cianPage.chooseFilterPrice());
        step("Выбираем город", () ->
            cianPage.chooseFilterGeo());
        step("Выполняем поиск", () ->
            cianPage.clickSearch());

        step("Проверяем результаты поиска", () ->
            cianPage.checkResultSearch());
    }

    @Test
    @DisplayName("Добавление в избранное в ЛК")
    void addFavoritesAuthorizationTest() {
        step("Открываем 1е популярное объявление", () -> {
            cianPage.choosePopularTab()
                    .saveName();
        });
        step("Добавляем объявление в избранное", () ->
            cianPage.clickAddFavorite());
        step("Проверяем в тултипе, что объявление добавилось в избранное", () ->
            cianPage.checkAddFavoriteTooltip());
        step("Открываем форму авторизации из тултипа", () ->
            cianPage.clickLogInFavorite());
        step("Вводим Email и пароль", () -> {
            cianPage.setValueEmail()
                    .setValuePassword()
                    .clickContinueLogIn();
        });
        step("Открываем избранное в личном кабинете", () ->
            cianPage.openPageFavorites());
        step("Открываем 1е объявление в избранном", () ->
            cianPage.openFavoriteCard());
        step("Проверяем, что это добавленное объявление", () -> {
            switchTo().window(1);
            cianPage.checkResultAddFavourite();
        });
    }

    @Test
    @DisplayName("Добавление в избранное без авторизации")
    void addFavoritesTest() {
        step("Открываем 1е популярное объявление", () -> {
            cianPage.choosePopularTab()
                .saveName();
        });
        step("Добавляем объявление в избранное", () ->
            cianPage.clickAddFavorite());
        step("Проверяем в тултипе, что объявление добавилось в избранное", () ->
            cianPage.checkAddFavoriteTooltip());
        step("Открываем избранное в шапке", () ->
            cianPage.openTooltipHeaderFavourite());
        step("Проверяем наличие добавленного объявления", () ->
            cianPage.checkResultAddFavouriteTooltipHeader());
    }

    @Test
    @DisplayName("Изменение города")
    void changeGeoTest() {
        step("Открываем выбор города", () ->
            cianPage.clickGeoSwitcher());
        step("Выбираем город", () ->
            cianPage.chooseCity());
        step("Проверяем, что выбрался нужный город", () ->
            cianPage.checkChangeGeo());
    }

    @Test
    @DisplayName("Проверка промо ссылки")
    void promoLinkTest() {
        step("Открываем ссылку на 1к квартиры", () ->
            cianPage.openPromoCard());
        step("Проверяем, что установились верные фильтры", () ->
            cianPage.checkMainFilter());
        step("Проверяем заголовок на странице", () ->
            cianPage.checkHeaderPage());
    }
}
