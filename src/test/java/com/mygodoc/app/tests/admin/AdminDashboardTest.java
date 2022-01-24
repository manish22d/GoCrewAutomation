package com.mygodoc.app.tests.admin;

import com.mygodoc.app.tests.BaseTest;
import com.mygodoc.app.pages.admin.AdminDashboardPage;
import com.mygodoc.app.pages.clinic.ClinicHomePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

@Epic("Admin Dashboard Test")
@Feature("Admin Section")
public class AdminDashboardTest extends BaseTest {
    @Autowired
    AdminDashboardPage dashboardPage;

    @Autowired
    ClinicHomePage clinicPage;

    @Test(priority = 0)
    public void verifyAllTabsDisplayedInDashboard() {
        List<String> expectedTabs = Arrays.asList("Manage Practices", "User Lookup", "GoCrew Admin", "EULA");
        System.out.println(dashboardPage.getTabs());
        assertThat("List did not matched", expectedTabs.containsAll(dashboardPage.getTabs()));
    }

    @Test(priority = 0)
    public void verifyAdminIsAbleToSearchClinic() {
        dashboardPage.searchUsingName("TestAutomationPractice1");
        System.out.println(dashboardPage.getClinicList());
    }


    @Test(priority = 1)
    public void verifyAdminIsAbleToNavigateToUserTab() {
        dashboardPage.navigateToUserTab();
        assertThat(dashboardPage.getTabTitle(), is(equalTo("User Lookup")));
    }

    @Test(priority = 1, dependsOnMethods = "verifyAdminIsAbleToNavigateToUserTab")
    public void verifyAdminIsAbleToSearchUser() {
        dashboardPage.searchUsingName("deepti t");
        System.out.println(dashboardPage.getUserList());
    }


    @Test(priority = 2)
    public void verifyAdminIsAbleToNavigateToGoCrewAdminTab() {
        dashboardPage.navigateToAdminTab();
        assertThat(dashboardPage.getTabTitle(), is(equalTo("Manage GoCrew Admins")));
    }

    @Test(priority = 3)
    public void verifyAdminIsAbleToNavigateToEULATab() {
        dashboardPage.navigateToEULATab();
        assertThat(dashboardPage.getTabTitle(), is(equalTo("Update GoCrew EULA")));
    }

    @Test(priority = 4)
    public void verifyAdminIsAbleToSelectClinic() {
        dashboardPage.navigateToPracticesTab();
        clinicPage = dashboardPage.getClinic("TestAutomationPractice1");
    }
}
