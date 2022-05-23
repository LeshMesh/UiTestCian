package com.todoist.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.todoist.config.Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.todoist.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoistPage {

    public SelenideElement
        inputUsername = $("#labeled-input-1"),
        inputPassword = $("#labeled-input-3"),

        filterInbox = $("#filter_inbox"),
        filterToday = $("#filter_today"),
        filterUpcoming = $("#filter_upcoming"),
        filterLabels = $("#filters_labels"),

        checkFilterContent = $(".simple_content"),
        calendar = $(".calendar"),

        monthYear = $(".upcoming_view__calendar__controls__picker"),
        dayMonth = $(".calendar__day--selected").$(".upcoming_view__day_cell__weekday"),
        dateMonth = $(".calendar__day--selected").$(".upcoming_view__day_cell__date__number"),

        openProject = $("[data-type=project_list_item]"),
        addProject = $(".expansion_panel__actions"),
        buttonAddProject = $(byText("Добавить")),
        nameProject = $("#edit_project_modal_field_name"),
        checkProjectList = $("#projects_list"),
        tooltipToaster = $("[data-testid=toaster]"),
        buttonNewTask = $("#quick_add_task_holder"),
        fieldInputNameTask = $(".public-DraftEditor-content"),
        fieldInputDescriptionTask = $(".task_editor__description_field"),
        openChoosePriorityTask = $(".item_actions_priority"),
        choosePriorityTask = $(byText("Приоритет " + numberPriority)),
        buttonAddTask = $(".task_editor__form_actions").$(byText("Добавить задачу")),
        addSection = $(".hover_action_button"),
        nameSection = $(".name"),
        buttonAddSection = $(".section_form").$(byText("Добавить раздел")),
        sectionList = $(".section_list");


    public TodoistPage logIn() {
        open("https://todoist.com/auth/login");
        inputUsername.setValue(Project.config.username());
        inputPassword.setValue(Project.config.password()).pressEnter();
        sleep(5000); //временно
        return this;
    }

    public TodoistPage openFilterInbox() {
        filterInbox.click();
        return this;
    }

    public TodoistPage checkOpenFilterInbox() {
        checkFilterContent.shouldHave(Condition.text("Входящие"));
        return this;
    }

    public TodoistPage openFilterToday() {
        filterToday.click();
        return this;
    }

    public TodoistPage checkOpenFilterToday() {
        checkFilterContent.shouldHave(Condition.text("Сегодня"));
        return this;
    }

    public TodoistPage openFilterLabels() {
        filterLabels.click();
        return this;
    }

    public TodoistPage checkOpenFilterLabels() {
        checkFilterContent.shouldHave(Condition.text("Фильтры и метки"));
        return this;
    }

    public TodoistPage openFilterUpcoming() {
        filterUpcoming.click();
        return this;
    }

    public TodoistPage checkOpenFilterUpcoming() {
        calendar.shouldBe(Condition.visible);
        return this;
    }

    public TodoistPage checkOpenDateUpcoming() {
        String dateCheck = monthYear.innerText() + " " + dayMonth.innerText() + " " + dateMonth.innerText();
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy E d");
        Date dateNow = new Date();
        try {
            Date date = formatter.parse(dateCheck);
            assertEquals(formatter.format(date), formatter.format(dateNow));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }

    public TodoistPage createProject() {
        addProject.click();
        return this;
    }

    public TodoistPage inputNameProject() {
        nameProject.setValue(projectName);
        return this;
    }

    public TodoistPage addNewProject() {
        buttonAddProject.click();
        return this;
    }

    public TodoistPage checkCreateProject() {
        checkProjectList.shouldHave(Condition.text(projectName));
        return this;
    }

    public TodoistPage createNewTask() {
        buttonNewTask.click();
        return this;
    }

    public TodoistPage inputNameTask() {
        fieldInputNameTask.setValue(taskName);
        return this;
    }

    public TodoistPage inputDescriptionTask() {
        fieldInputDescriptionTask.setValue(taskDescription);
        return this;
    }

    public TodoistPage openChoosePriorityTask() {
        openChoosePriorityTask.click();
        return this;
    }

    public TodoistPage choosePriorityTask() {
        choosePriorityTask.click();
        return this;
    }

    public TodoistPage addNewTask() {
        buttonAddTask.click();
        return this;
    }

    public TodoistPage checkTooltipCreateTask() {
        tooltipToaster.shouldHave(Condition.text("Добавлена задача"));
        return this;
    }

    public TodoistPage openProject() {
        openProject.click();
        return this;
    }

    public TodoistPage addSection() {
        addSection.click();
        return this;
    }

    public TodoistPage setNameSection() {
        nameSection.setValue(sectionName);
        return this;
    }

    public TodoistPage buttonAddSection() {
        buttonAddSection.click();
        return this;
    }

    public TodoistPage checkAddSection() {
        sectionList.shouldHave(Condition.text(sectionName));
        return this;
    }
}
