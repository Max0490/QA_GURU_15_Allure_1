package Homework;

import org.junit.jupiter.api.Test;
import qa.guru.allure.WebSteps;

public class StepsTestIssue {

    WebStepsIssue steps = new WebSteps();

    String repo = "Allure_Report_QA_GURU";

    @Test
    void searchIssue() {
        steps.openMainPage();
        steps.searchRepo(repo);
        steps.searchIssue();
    }






}
