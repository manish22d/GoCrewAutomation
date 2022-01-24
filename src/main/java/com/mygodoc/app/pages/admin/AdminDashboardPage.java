package com.mygodoc.app.pages.admin;

import com.mygodoc.app.enums.Tabs;
import com.mygodoc.app.pages.BasePage;
import com.mygodoc.app.pages.clinic.ClinicHomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminDashboardPage extends BasePage {

    @Autowired
    ClinicHomePage clinicPage;

    @FindBy(tagName = "h4")
    WebElement tabTitle;

    @FindBy(css = "input.MuiInputBase-input")
    WebElement searchTextbox;

    @FindBy(css = ".base-card p")
    List<WebElement> clinics;

    @FindBy(css = "span.MuiTab-wrapper")
    List<WebElement> tabs;

    @FindBy(xpath = "//div[./span[contains(.,'Name')]]/following-sibling::div/div/div/span[1]")
    List<WebElement> userNames;



    @Step
    public List<String> getClinicList(){
        wait.until(visibilityOfAllElements(clinics));
        return clinics.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step
    public List<String> getUserList(){
        wait.until(visibilityOfAllElements(userNames));
        return userNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step
    public ClinicHomePage getClinic(String clinicName){
        wait.until(visibilityOfAllElements(clinics));
        clinics.stream().filter(clinic-> clinic.getText().equalsIgnoreCase(clinicName)).findFirst().orElseThrow(null).click();
        waitForPageToLoad();
        return clinicPage;
    }

    @Step
    public List<String> getTabs() {
        wait.until(visibilityOfAllElements(tabs));
        return tabs.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public AdminDashboardPage searchUsingName(String name) {
        wait.until(visibilityOf(searchTextbox));
        searchTextbox.clear();
        searchTextbox.click();
        searchTextbox.sendKeys(name);
        waitForPageToLoad();
        return this;
    }
    @Step
    public String getTabTitle(){
        wait.until(visibilityOfAllElements(tabTitle));
        return tabTitle.getText();
    }

    @Step
    public AdminDashboardPage navigateToPracticesTab() {
        wait.until(visibilityOfAllElements(tabs));
        tabs.stream().filter(tab-> tab.getText().equalsIgnoreCase(Tabs.MANAGE_PRACTICES.name)).findFirst().orElseThrow(null).click();
        waitForPageToLoad();
        return this;
    }

    @Step
    public AdminDashboardPage navigateToUserTab() {
        wait.until(visibilityOfAllElements(tabs));
        tabs.stream().filter(tab-> tab.getText().equalsIgnoreCase(Tabs.USER_LOOKUP.name)).findFirst().orElseThrow(null).click();
        waitForPageToLoad();
        return this;
    }

    @Step
    public AdminDashboardPage navigateToAdminTab() {
        wait.until(visibilityOfAllElements(tabs));
        tabs.stream().filter(tab-> tab.getText().equalsIgnoreCase(Tabs.GOCREW_ADMIN.name)).findFirst().orElseThrow(null).click();
        waitForPageToLoad();
        return this;
    }

    @Step
    public AdminDashboardPage navigateToEULATab() {
        wait.until(visibilityOfAllElements(tabs));
        tabs.stream().filter(tab-> tab.getText().equalsIgnoreCase(Tabs.EULA.name)).findFirst().orElseThrow(null).click();
        waitForPageToLoad();
        return this;
    }



}
