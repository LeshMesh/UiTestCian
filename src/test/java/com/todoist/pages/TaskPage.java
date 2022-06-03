package com.todoist.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.todoist.TestData.*;

public class TaskPage {

    public SelenideElement
            tooltipToaster = $("[data-testid=toaster]"),
            buttonNewTask = $("#quick_add_task_holder"),
            fieldInputNameTask = $(".public-DraftEditor-content"),
            fieldInputDescriptionTask = $(".task_editor__description_field"),
            openChoosePriorityTask = $(".item_actions_priority"),
            choosePriorityTask = $(byText("Приоритет " + numberPriority)),
            buttonAddTask = $(".task_editor__form_actions").$(byText("Добавить задачу"));

    public TaskPage createNewTask() {
        buttonNewTask.click();
        return this;
    }

    public TaskPage inputNameTask() {
        fieldInputNameTask.setValue(taskName);
        return this;
    }

    public TaskPage inputDescriptionTask() {
        fieldInputDescriptionTask.setValue(taskDescription);
        return this;
    }

    public TaskPage openChoosePriorityTask() {
        openChoosePriorityTask.click();
        return this;
    }

    public TaskPage choosePriorityTask() {
        choosePriorityTask.click();
        return this;
    }

    public TaskPage addNewTask() {
        buttonAddTask.click();
        return this;
    }

    public TaskPage checkTooltipCreateTask() {
        tooltipToaster.shouldHave(Condition.text("Добавлена задача"));
        return this;
    }
}
