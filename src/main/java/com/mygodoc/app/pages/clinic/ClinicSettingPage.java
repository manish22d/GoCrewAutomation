package com.mygodoc.app.pages.clinic;

import com.mygodoc.app.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClinicSettingPage extends BasePage {
    @FindBy(css = "div.action-card p:first-child")
    List<WebElement> settingOptions;


    public List<String> getAllSettings() {
        wait.until(visibilityOfAllElements(settingOptions));
        return settingOptions.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public ClinicSettingPage openSetting(String settingName) {
        wait.until(visibilityOfAllElements(settingOptions));
        settingOptions.stream().filter(setting -> settingName.equalsIgnoreCase(setting.getText())).findFirst().orElseThrow(null).click();
        waitForPageToLoad();
        return this;
    }
}
