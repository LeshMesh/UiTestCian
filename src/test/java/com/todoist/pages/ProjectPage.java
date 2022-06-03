package com.todoist.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.todoist.TestData.projectName;
import static com.todoist.TestData.sectionName;

public class ProjectPage {

    public SelenideElement
            openProject = $("[data-type=project_list_item]"),
            addProject = $(".expansion_panel__actions"),
            buttonAddProject = $(byText("Добавить")),
            nameProject = $("#edit_project_modal_field_name"),
            checkProjectList = $("#projects_list"),
            addSection = $(".hover_action_button"),
            nameSection = $(".name"),
            buttonAddSection = $(".section_form").$(byText("Добавить раздел")),
            sectionList = $(".section_list");

    public ProjectPage createProject() {
        addProject.click();
        return this;
    }

    public ProjectPage inputNameProject() {
        nameProject.setValue(projectName);
        return this;
    }

    public ProjectPage addNewProject() {
        buttonAddProject.click();
        return this;
    }

    public ProjectPage checkCreateProject() {
        checkProjectList.shouldHave(Condition.text(projectName));
        return this;
    }

    public ProjectPage openProject() {
        openProject.click();
        return this;
    }

    public ProjectPage addSection() {
        addSection.click();
        return this;
    }

    public ProjectPage setNameSection() {
        nameSection.setValue(sectionName);
        return this;
    }

    public ProjectPage buttonAddSection() {
        buttonAddSection.click();
        return this;
    }

    public ProjectPage checkAddSection() {
        sectionList.shouldHave(Condition.text(sectionName));
        return this;
    }
}
