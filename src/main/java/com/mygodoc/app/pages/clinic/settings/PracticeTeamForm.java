package com.mygodoc.app.pages.clinic.settings;

import com.mygodoc.app.annotations.Form;
import com.mygodoc.app.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Form
public class PracticeTeamForm extends BasePage {
    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(name = "designations")
    WebElement title;

    @FindBy(name = "phone")
    WebElement phone;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "npi")
    WebElement npi;

    @FindBy(css = "button[type='submit']")
    WebElement saveLocation;

    @FindBy(css = "button[type='button'] span.MuiButton-label")
    WebElement finished;

    public void addTeam() {
        waitForPageToLoad();
        wait.until(visibilityOf(firstName));
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        title.sendKeys(faker.name().title());
        phone.click();
        phone.sendKeys(faker.phoneNumber().phoneNumber());
        email.sendKeys("test@gmail.com");
    }
}
