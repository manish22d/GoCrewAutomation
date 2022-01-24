package com.mygodoc.app.tests.clinic;

import com.mygodoc.app.pages.admin.AdminDashboardPage;
import com.mygodoc.app.pages.clinic.ClinicHomePage;
import com.mygodoc.app.pages.clinic.TriageDashboardPage;
import com.mygodoc.app.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Epic("Triage Dashboard Test")
@Feature("Clinic Triage")
public class TriageDashboardTest extends BaseTest {
    @Autowired
    AdminDashboardPage dashboardPage;

    @Autowired
    ClinicHomePage clinicPage;

    @Autowired
    TriageDashboardPage triagePage;

    @BeforeClass
    public void navigateToTriageDashboardPage(){
        clinicPage = dashboardPage.getClinic("TestAutomationPractice1");
        triagePage = clinicPage.navigateToTriageDashboard();
    }

    @Test
    public void verifyWaitingSectionDisplayedCorrectly(){
        assertThat(triagePage.isWaitingSectionDisplayed(), is(true));
    }

    @Test
    public void verifyActiveSectionDisplayedCorrectly(){
        assertThat(triagePage.isActiveSectionDisplayed(), is(true));
    }
}
