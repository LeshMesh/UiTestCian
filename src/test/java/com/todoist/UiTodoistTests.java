package com.todoist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class UiTodoistTests extends TestBase {

    @Test
    @DisplayName("Проверка открытия страниц основных фильтров")
    void checkOpenTopMenuFiltersTest() {
        step("Авторизуемся", () ->
                logInPage.logIn());
        step("Проверяем открытие фильтра Входящие", () -> {
                topFilterPage.openFilterInbox()
                    .checkOpenFilterInbox();
        });
        step("Проверяем открытие фильтра Сегодня", () -> {
                topFilterPage.openFilterToday()
                    .checkOpenFilterToday();
        });
        step("Проверяем открытие фильтра Фильтры и метки", () -> {
                topFilterPage.openFilterLabels()
                    .checkOpenFilterLabels();
        });
        step("Проверяем открытие фильтра Предстоящее", () -> {
                topFilterPage.openFilterUpcoming()
                    .checkOpenFilterUpcoming();
        });
    }

    @Test
    @DisplayName("Фильтр Предстоящее открывается на текущей дате")
    void nowDateFilterUpcomingTest() {
        step("Авторизуемся", () ->
                logInPage.logIn());
        step("Открываем фильтр Предстоящее", () ->
                topFilterPage.openFilterUpcoming());
        step("Проверяем активную дату фильтра Предстоящее", () ->
                topFilterPage.checkOpenDateUpcoming());
    }

    @Test
    @DisplayName("Добавить раздел в проекте")
    void editProjectTest() {
        step("Авторизуемся", () ->
                logInPage.logIn());
        step("Открываем проект", () ->
                projectPage.openProject());
        step("Открываем Добавить раздел", () ->
                projectPage.addSection());
        step("Вводим имя раздела", () ->
                projectPage.setNameSection());
        step("Добавляем раздел", () ->
                projectPage.buttonAddSection());
        step("Проверяем, что раздел добавлен", () ->
                projectPage.checkAddSection());
    }

    @Test
    @DisplayName("Добавить задачу")
    void addNewTaskTest() {
        step("Авторизуемся", () ->
                logInPage.logIn());
        step("Открываем Добавить задачу", () ->
                taskPage.createNewTask());
        step("Вводим имя и описание задачи", () -> {
                taskPage.inputNameTask();
                taskPage.inputDescriptionTask();
        });
        step("Выбираем приоритет задачи", () -> {
                taskPage.openChoosePriorityTask();
                taskPage.choosePriorityTask();
        });
        step("Добавляем задачу", () ->
                taskPage.addNewTask());
        step("Проверяем добавление задачи", () ->
                taskPage.checkTooltipCreateTask());
    }

    @Test
    @DisplayName("Создать проект")
    void createProjectTest() {
        step("Авторизуемся", () ->
                logInPage.logIn());
        step("Нажимаем Создать проект", () ->
                projectPage.createProject());
        step("Задаем имя проекта", () ->
                projectPage.inputNameProject());
        step("Добавляем проект", () ->
                projectPage.addNewProject());
        step("Проверяем, что проект создался", () ->
                projectPage.checkCreateProject());
    }
}
