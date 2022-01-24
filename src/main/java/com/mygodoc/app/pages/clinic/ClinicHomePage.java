package com.mygodoc.app.pages.clinic;

import com.mygodoc.app.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

@Component
public class ClinicHomePage extends BasePage {
    @Autowired
    ClinicSettingPage clinicSetting;

    @Autowired
    ClinicProfilePage clinicProfile;

    @Autowired
    PatientManagementPage patientMgmt;

    @Autowired
    TriageDashboardPage triageDashboard;

    @FindBy(css = "img[alt='home']")
    WebElement homeTabLink;

    @FindBy(css = "img[alt='profile']")
    WebElement profileTabLink;

    @FindBy(css = "img[alt='settings']")
    WebElement settingsTabLink;

    @FindBy(css = "div.header-title-component h1")
    WebElement headerDropdown;

    @FindBy(css = "div.header-menu-item ")
    List<WebElement> dropdownOptions;

    @Step
    public TriageDashboardPage navigateToHomeTab() {
        wait.until(elementToBeClickable(homeTabLink));
        homeTabLink.click();
        waitForPageToLoad();
        return triageDashboard;
    }

    @Step
    public ClinicProfilePage navigateToProfileTab() {
        wait.until(elementToBeClickable(profileTabLink));
        profileTabLink.click();
        waitForPageToLoad();
        return clinicProfile;
    }

    @Step
    public ClinicSettingPage navigateToSettingsTab() {
        wait.until(elementToBeClickable(settingsTabLink));
        settingsTabLink.click();
        waitForPageToLoad();
        return clinicSetting;
    }


    @Step
    public TriageDashboardPage navigateToTriageDashboard(){
        wait.until(elementToBeClickable(headerDropdown));
        headerDropdown.click();

        wait.until(visibilityOfAllElements(dropdownOptions));
        dropdownOptions.stream().filter(option -> option.getText().equalsIgnoreCase("Triage Dashboard")).findFirst().orElseThrow(null).click();
        waitForPageToLoad();

        return triageDashboard;
    }

    @Step
    public PatientManagementPage navigateToPatientMgmtDashboard(){
        wait.until(elementToBeClickable(headerDropdown));
        headerDropdown.click();

        wait.until(visibilityOfAllElements(dropdownOptions));
        dropdownOptions.stream().filter(option -> option.getText().equalsIgnoreCase("Patient Management")).findFirst().orElseThrow(null).click();
        waitForPageToLoad();

        return patientMgmt;
    }

}
