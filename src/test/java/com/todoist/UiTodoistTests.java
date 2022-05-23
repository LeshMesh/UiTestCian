package com.todoist;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UiTodoistTests extends TestBase{

    @Test
    @DisplayName("Проверка открытия страниц основных фильтров")
    void checkOpenTopMenuFiltersTest() {
        Allure.step("Авторизуемся", () ->
            todoistPage.logIn());
        Allure.step("Проверяем открытие фильтра Входящие", () -> {
            todoistPage.openFilterInbox()
                    .checkOpenFilterInbox();
        });
        Allure.step("Проверяем открытие фильтра Сегодня", () -> {
            todoistPage.openFilterToday()
                    .checkOpenFilterToday();
        });
        Allure.step("Проверяем открытие фильтра Фильтры и метки", () -> {
            todoistPage.openFilterLabels()
                    .checkOpenFilterLabels();
        });
        Allure.step("Проверяем открытие фильтра Предстоящее", () -> {
            todoistPage.openFilterUpcoming()
                    .checkOpenFilterUpcoming();
        });
    }

    @Test
    @DisplayName("Фильтр Предстоящее открывается на текущей дате")
    void nowDateFilterUpcomingTest() {
        Allure.step("Авторизуемся", () ->
            todoistPage.logIn());
        Allure.step("Открываем фильтр Предстоящее", () ->
            todoistPage.openFilterUpcoming());
        Allure.step("Проверяем активную дату фильтра Предстоящее", () ->
            todoistPage.checkOpenDateUpcoming());
    }

    @Test
    @DisplayName("Добавить раздел в проекте")
    void editProjectTest() {
        Allure.step("Авторизуемся", () ->
            todoistPage.logIn());
        Allure.step("Открываем проект", () ->
            todoistPage.openProject());
        Allure.step("Открываем Добавить раздел", () ->
            todoistPage.addSection());
        Allure.step("Вводим имя раздела", () ->
            todoistPage.setNameSection());
        Allure.step("Добавляем раздел", () ->
            todoistPage.buttonAddSection());
        Allure.step("Проверяем, что раздел добавлен", () ->
            todoistPage.checkAddSection());
    }

    @Test
    @DisplayName("Добавить задачу")
    void addNewTaskTest() {
        Allure.step("Авторизуемся", () ->
            todoistPage.logIn());
        Allure.step("Открываем Добавить задачу", () ->
            todoistPage.createNewTask());
        Allure.step("Вводим имя и описание задачи", () -> {
            todoistPage.inputNameTask();
            todoistPage.inputDescriptionTask();
        });
        Allure.step("Выбираем приоритет задачи", () -> {
            todoistPage.openChoosePriorityTask();
            todoistPage.choosePriorityTask();
        });
        Allure.step("Добавляем задачу", () ->
            todoistPage.addNewTask());
        Allure.step("Проверяем добавление задачи", () ->
            todoistPage.checkTooltipCreateTask());
    }

    @Test
    @DisplayName("Создать проект")
    void createProjectTest() {
        Allure.step("Авторизуемся", () ->
                todoistPage.logIn());
        Allure.step("Нажимаем Создать проект", () ->
                todoistPage.createProject());
        Allure.step("Задаем имя проекта", () ->
                todoistPage.inputNameProject());
        Allure.step("Добавляем проект", () ->
                todoistPage.addNewProject());
        Allure.step("Проверяем, что проект создался", () ->
                todoistPage.checkCreateProject());
    }
}
