package com.mygodoc.app.tests.clinic;

import com.mygodoc.app.enums.Setting;
import com.mygodoc.app.pages.admin.AdminDashboardPage;
import com.mygodoc.app.pages.clinic.ClinicHomePage;
import com.mygodoc.app.pages.clinic.ClinicSettingPage;
import com.mygodoc.app.pages.clinic.settings.BusinessInformationForm;
import com.mygodoc.app.pages.clinic.settings.ContentLibraryForm;
import com.mygodoc.app.pages.clinic.settings.LocationForm;
import com.mygodoc.app.pages.clinic.settings.PracticeTeamForm;
import com.mygodoc.app.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Epic("Clinic Settings Test")
@Feature("Clinic Settings")
public class ClinicSettingsTest extends BaseTest {
    @Autowired
    AdminDashboardPage dashboardPage;

    @Autowired
    ClinicHomePage clinicPage;

    @Autowired
    ClinicSettingPage clinicSettingPage;

    @Autowired
    BusinessInformationForm businessInformationForm;

    @Autowired
    ContentLibraryForm contentLibraryForm;

    @Autowired
    LocationForm locationForm;

    @Autowired
    PracticeTeamForm practiceTeamForm;

    @BeforeClass
    public void navigateToClinicSettingPage(){
        clinicPage = dashboardPage.getClinic("TestAutomationPractice1");
        clinicSettingPage = clinicPage.navigateToSettingsTab();
    }

    @Test
    public void verifyAllSettingsDisplayedCorrectly(){
        clinicPage.navigateToSettingsTab();
        List<String> expectedTabs = Arrays.asList("Business information", "Brand settings", "Locations", "Practice team", "Content library", "Analytics", "Account billing");
        System.out.println(clinicSettingPage.getAllSettings());
    }

    @Test
    public void userIsAbleToUpdateBusinessInformation(){
        clinicPage.navigateToSettingsTab();
        clinicSettingPage.openSetting(Setting.BUSINESS_INFORMATION.name);
        businessInformationForm.fillForm();
    }

    @Test
    public void userIsAbleToUpdateBrandSetting(){
        clinicPage.navigateToSettingsTab();
        clinicSettingPage.openSetting(Setting.BRAND_SETTINGS.name);
    }

    @Test
    public void userIsAbleToUpdateLocationSetting(){
        clinicPage.navigateToSettingsTab();
        clinicSettingPage.openSetting(Setting.LOCATIONS.name);
        locationForm.fillForm();
    }

    @Test
    public void userIsAbleToAddPracticeTeam(){
        clinicPage.navigateToSettingsTab();
        clinicSettingPage.openSetting(Setting.PRACTICE_TEAM.name);
        practiceTeamForm.addTeam();
    }

    @Test
    public void userIsAbleToUpdateContentLibrary(){
        clinicPage.navigateToSettingsTab();
        clinicSettingPage.openSetting(Setting.CONTENT_LIBRARY.name);
        contentLibraryForm.fillForm();
    }
}
